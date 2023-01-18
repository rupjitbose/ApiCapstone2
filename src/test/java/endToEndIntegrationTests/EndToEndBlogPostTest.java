package endToEndIntegrationTests;

import blogs.BlogService;
import blogs.create.CreateBlogPostResquestBody;
import blogs.create.response.CreateBlogPostResponse;
import blogs.delete.DeleteBlogPostResponse;
import blogs.get.GetPostResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EndToEndBlogPostTest {
    private BlogService blogService;

    @BeforeClass
    private void beforeClass(){
        blogService=new BlogService();
    }

    @Test
    public void shouldCreateGetAndDeleteBlogPost(){

        //arrange
        CreateBlogPostResquestBody createBlogPostResquestBody=new CreateBlogPostResquestBody.Builder().build();
        CreateBlogPostResponse createBlogPostResponse= blogService.createBlog(createBlogPostResquestBody);
        String id=createBlogPostResponse.getId();
        GetPostResponse getPostResponse=blogService.getPostById(id);
        //act
        DeleteBlogPostResponse deleteBlogPostResponse=blogService.deletePostById(id);
        //assert
        blogService.getPostExpectingError(id).assertError(404,"RESOURCE_NOT_FOUND");
    }
}
