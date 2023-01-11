package blogPostTest;

import blogs.BlogService;
import blogs.delete.DeleteBlogPostResponse;
import blogs.get.GetPostResponse;
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

        //act
        DeleteBlogPostResponse deleteBlogPostResponse=blogService.deletePostById("63be59cbd5837bbbf608564f");
        //assert
        Assert.assertEquals(deleteBlogPostResponse.getId(),"63be59cbd5837bbbf608564f");
        Assert.assertEquals(deleteBlogPostResponse.getStatusCode(),200);
    }
}
