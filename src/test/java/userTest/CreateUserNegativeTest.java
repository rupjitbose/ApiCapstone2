package userTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

public class CreateUserNegativeTest {

    private UserService userService;

    @BeforeClass
    private void beforeClass(){
        userService=new UserService();
    }

    @Test
    public void shouldThrowErrorIfAnUserIsCreatedWithExistingEmail(){
        //arrange
        CreateUserRequestBody cuReqBody=new CreateUserRequestBody.Builder().email("379d3ab8-df77-49b2-8c72-4c81a65b0669@gmail.com").build();
        //act
        CreateUserErrorResponse createUserErrorResponse = userService.userErrorResponse(cuReqBody);
        //assert
        Assert.assertEquals(createUserErrorResponse.getStatusCode(),400);
        Assert.assertEquals(createUserErrorResponse.getData().getEmail(),"Email already used");



    }
}
