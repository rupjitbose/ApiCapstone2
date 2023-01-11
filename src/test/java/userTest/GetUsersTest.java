package userTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;
import users.get.GetUserResponse;

import static io.restassured.RestAssured.given;

public class GetUsersTest {

    private UserService userService;

    @BeforeClass
    private void beforeClass(){
        userService=new UserService();
    }
@Test
    public void shouldGetListOfUsersOfGivenLimit(){
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

    @Test
    public void shouldGetListOfUsersUnderTheAccount(){
        //arrange
        String queryParamName="created";
        int queryParamValue=1;
        //act
        GetUserResponse getUserResponse=userService.getAllUser(queryParamName, queryParamValue);
        //assert
        Assert.assertEquals(getUserResponse.getStatusCode(),200);
        Assert.assertEquals(getUserResponse.getData().size(),getUserResponse.getTotal());

    }

}
