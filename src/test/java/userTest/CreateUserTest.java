package userTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import users.UserService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserSuccessResponse;

import java.io.IOException;

public class CreateUserTest {

    private UserService userService;

    @BeforeGroups(groups = {"smoke","default"})
    private void beforeClass(){
        userService=new UserService();
    }
    @Test(groups = {"default"})
    public void shouldCreateAnUser() throws IOException {
        //arrange
        CreateUserRequestBody cuReqBody=new CreateUserRequestBody.Builder().build();
        //act
        CreateUserSuccessResponse createUserSuccessResponse = userService.createUser(cuReqBody);
        //assert
        createUserSuccessResponse.assertUserInfo(cuReqBody);

    }
}
