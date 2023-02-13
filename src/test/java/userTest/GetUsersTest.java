package userTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import users.UserService;
import users.get.GetUserResponse;
import java.io.IOException;


public class GetUsersTest {


    private UserService userService;

    @BeforeGroups(groups = {"smoke","default"})
    private void beforeClass(){
        userService=new UserService();
    }
@Test(groups = {"default"})
    public void shouldGetListOfUsersOfGivenLimit() throws IOException {
    //arrange
    String queryParamName="limit";
    int queryParamValue=10;
    //act
    GetUserResponse getUserResponse=userService.getAllUser(queryParamName, queryParamValue);
    //assert
    Assert.assertEquals(getUserResponse.getStatusCode(),200);
    Assert.assertEquals(getUserResponse.getLimit(),10);
    Assert.assertEquals(getUserResponse.getData().size(),10);
    }

    @Test(groups = {"smoke","default"})
    public void shouldGetListOfUsersUnderTheAccount() throws IOException {
        //arrange
        String queryParamName="created";
        int queryParamValue=1;
        //act
        GetUserResponse getUserResponse=userService.getAllUser(queryParamName, queryParamValue);
        //assert
        Assert.assertEquals(getUserResponse.getStatusCode(),200);
        //Assert.assertEquals(getUserResponse.getData().size(),getUserResponse.getTotal());
    }

}
