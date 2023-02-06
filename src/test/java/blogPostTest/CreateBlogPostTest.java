package blogPostTest;

import blogs.BlogService;
import blogs.create.CreateBlogPostResquestBody;
import blogs.create.response.CreateBlogPostResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;

import java.io.IOException;

public class CreateBlogPostTest {

    private BlogService blogService;

    @BeforeClass
    private void beforeClass(){
        blogService=new BlogService();
    }

    @Test
    public void shouldCreateBlogPost() throws IOException {

        //arrange
        CreateBlogPostResquestBody createBlogPostResquestBody=new CreateBlogPostResquestBody.Builder().build();
        //act
        CreateBlogPostResponse createBlogPostResponse= blogService.createBlog(createBlogPostResquestBody);
        //assert
        createBlogPostResponse.assertBlogPost(createBlogPostResquestBody);

    }
}
