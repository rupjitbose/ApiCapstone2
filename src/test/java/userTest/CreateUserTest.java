package userTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserSuccessResponse;

import static io.restassured.RestAssured.given;

public class CreateUserTest {

    private UserService userService;

    @BeforeClass
    private void beforeClass(){
        userService=new UserService();
    }
    @Test
    public void shouldCreateAnUser(){
        //arrange
        CreateUserRequestBody cuReqBody=new CreateUserRequestBody.Builder().build();
        //act
        CreateUserSuccessResponse createUserSuccessResponse = userService.createUser(cuReqBody);
        //assert
        createUserSuccessResponse.assertUserInfo(cuReqBody);

    }
}
