package blogPostTest;

import blogs.BlogService;
import blogs.get.GetPostResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetBlogPostTest {


    private BlogService blogService;

    @BeforeClass
    private void beforeClass(){
        blogService=new BlogService();
    }

    @Test
    public void shouldGetPostById(){

        //act
        GetPostResponse getPostResponse=blogService.getPostById("63be48bbd1eb2d74bb55e2bd");
        //assert
        Assert.assertEquals(getPostResponse.getId(),"63be48bbd1eb2d74bb55e2bd");
        Assert.assertEquals(getPostResponse.getStatusCode(),200);
    }
}
