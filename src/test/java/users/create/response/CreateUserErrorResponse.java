package users.create.response;
import lombok.Getter;
import lombok.Setter;


@Getter
public class CreateUserErrorResponse {

    @Setter
    private  int statusCode;

    private Data data;

    private String error;

    @Getter
    public class Data {
        private String email;
        private  String firstName;
        private  String lastName;
    }

}
