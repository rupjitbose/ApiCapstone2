package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserSuccessResponse;
import users.get.GetUserResponse;

import static io.restassured.RestAssured.given;

public class UserClient {

    public Response create(CreateUserRequestBody body) {
        Response response = given()
                .header("app-id", "63b7f58f61cc2870a39aa26f")
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("https://dummyapi.io/data/v1/user/create");
        response.then().log().body();
        return response;
    }

    public Response getAll(String queryParamName, int queryParamValue) {
        Response response = given()
                .header("app-id", "63b7f58f61cc2870a39aa26f")
                .queryParam(queryParamName, queryParamValue)
                .when().get("https://dummyapi.io/data/v1/user");

        response.then().log().body();
        return response;
    }

}
