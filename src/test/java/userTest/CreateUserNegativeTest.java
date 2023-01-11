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
        CreateUserRequestBody cuReqBody=new CreateUserRequestBody.Builder().email("mayurk@ttabvag.com").build();
        //act
        CreateUserErrorResponse createUserErrorResponse = userService.userErrorResponse(cuReqBody);
        //assert
        Assert.assertEquals(createUserErrorResponse.getStatusCode(),400);
        Assert.assertEquals(createUserErrorResponse.getData().getEmail(),"Email already used");



    }
}
