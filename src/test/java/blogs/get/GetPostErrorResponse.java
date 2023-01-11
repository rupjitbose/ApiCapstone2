package blogs.get;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class GetPostErrorResponse {
    @Setter
    private  int statusCode;
    private String error;

    public void assertError(int expectedStatusCode, String msg) {
        Assert.assertEquals(this.statusCode,expectedStatusCode);
        Assert.assertEquals(this.error,msg);
    }
}
