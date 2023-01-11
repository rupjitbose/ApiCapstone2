package blogs.create.response;

import blogs.create.CreateBlogPostResquestBody;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import static org.testng.Assert.*;

@Getter
public class CreateBlogPostResponse {

    @Setter
    private  int statusCode;
    private Owner owner;

    private String image;

    private String link;

    private String publishDate;

    private String id;

    private String text;

    private String updatedDate;

    private int likes;

    private List<String> tags;

    public void assertBlogPost(CreateBlogPostResquestBody createBlogPostResquestBody) {
        assertEquals(this.statusCode,200);
        assertEquals(this.getOwner().id,createBlogPostResquestBody.getOwner());
        assertEquals(this.image,createBlogPostResquestBody.getImage());
        assertEquals(this.text,createBlogPostResquestBody.getText());
        assertEquals(this.likes,createBlogPostResquestBody.getLikes());
        assertEquals(this.tags,createBlogPostResquestBody.getTags());
    }

    @Getter
    public static class Owner {
        private String firstName;

        private String lastName;

        private String id;
    }

}
