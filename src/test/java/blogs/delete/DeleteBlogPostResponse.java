package blogs.delete;
import lombok.Getter;
import lombok.Setter;

@Getter
public class DeleteBlogPostResponse {
    @Setter
    private int statusCode;
    private String id;
}
