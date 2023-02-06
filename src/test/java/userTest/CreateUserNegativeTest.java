package userTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserSuccessResponse;

import java.io.IOException;

public class CreateUserNegativeTest {

    private UserService userService;

    @BeforeClass
    private void beforeClass(){
        userService=new UserService();
    }

    @Test
    public void shouldThrowErrorIfAnUserIsCreatedWithExistingEmail() throws IOException {


        //arrange
        CreateUserRequestBody createUserRequestBody=new CreateUserRequestBody.Builder().build();

        userService.createUser(createUserRequestBody);
        //act
        CreateUserErrorResponse createUserErrorResponse = userService.userErrorResponse(createUserRequestBody);
        //assert
        Assert.assertEquals(createUserErrorResponse.getStatusCode(),400);
        Assert.assertEquals(createUserErrorResponse.getData().getEmail(),"Email already used");



    }
}
