package users.create.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.stream.Collectors;

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
