package blogPostTest;

import blogs.BlogService;
import blogs.create.CreateBlogPostResquestBody;
import blogs.create.response.CreateBlogPostResponse;
import blogs.delete.DeleteBlogPostResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteBlogPost {
    private BlogService blogService;

    @BeforeClass
    private void beforeClass(){
        blogService=new BlogService();
    }

    @Test
    public void shouldDeletePostById(){
        //arrange
        CreateBlogPostResquestBody createBlogPostResquestBody=new CreateBlogPostResquestBody.Builder().build();
        String id=blogService.createBlog(createBlogPostResquestBody).getId();
        //act
        DeleteBlogPostResponse deleteBlogPostResponse=blogService.deletePostById(id);
        //assert
        Assert.assertEquals(deleteBlogPostResponse.getId(),id);
        Assert.assertEquals(deleteBlogPostResponse.getStatusCode(),200);
    }
}
