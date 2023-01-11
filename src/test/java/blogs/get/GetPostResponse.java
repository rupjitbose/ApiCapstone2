package blogs.get;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class GetPostResponse {

    @Setter
    private  int statusCode;
    private Owner owner;
    private String image;
    private String link;
    private String publishDate;
    private String id;
    private String text;
    private String updatedDate;
    private String likes;
    private List<String> tags;

    @Getter
    public class Owner {
        private String firstName;
        private String lastName;
        private String id;
    }
}
