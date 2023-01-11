package users;

import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserSuccessResponse;
import users.get.GetUserResponse;

public class UserService {


    public CreateUserSuccessResponse createUser(CreateUserRequestBody body) {
        Response response=new UserClient().create(body);
        CreateUserSuccessResponse createUserSuccessResponse = response.as(CreateUserSuccessResponse.class);
        createUserSuccessResponse.setStatusCode(response.statusCode());
        return createUserSuccessResponse;
    }

    public CreateUserErrorResponse userErrorResponse(CreateUserRequestBody body) {
        Response response=new UserClient().create(body);
        CreateUserErrorResponse createUserErrorResponse = response.as(CreateUserErrorResponse.class);
        createUserErrorResponse.setStatusCode(response.statusCode());
        return createUserErrorResponse;
    }

    public GetUserResponse getAllUser(String queryParamName, int queryParamValue) {
        Response response = new UserClient().getAll(queryParamName, queryParamValue);
        GetUserResponse getUserResponse=response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(response.statusCode());
        return getUserResponse;
    }

}
