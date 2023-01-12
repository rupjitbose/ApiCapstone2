package blogPostTest;

import blogs.BlogService;
import blogs.create.CreateBlogPostResquestBody;
import blogs.create.response.CreateBlogPostResponse;
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
        //arrange
        CreateBlogPostResquestBody createBlogPostResquestBody=new CreateBlogPostResquestBody.Builder().build();
        String id=blogService.createBlog(createBlogPostResquestBody).getId();
        //act
        GetPostResponse getPostResponse=blogService.getPostById(id);
        //assert
        Assert.assertEquals(getPostResponse.getId(),id);
        Assert.assertEquals(getPostResponse.getStatusCode(),200);
    }
}
