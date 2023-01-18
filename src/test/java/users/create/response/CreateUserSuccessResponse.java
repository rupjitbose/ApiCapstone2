package users.create.response;

import lombok.Getter;
import lombok.Setter;
import users.create.CreateUserRequestBody;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class CreateUserSuccessResponse {

    @Setter
    private  int statusCode;
    private String firstName;
    private String lastName;
    private String id;
    private String updatedDate;
    private String email;
    private String registerDate;

    public void assertUserInfo(CreateUserRequestBody cuReqBody) {
        assertEquals(this.getStatusCode(),200);
        assertNotNull(this.getId());
        assertEquals(this.getFirstName(),cuReqBody.getFirstName());
        assertEquals(this.getLastName(),cuReqBody.getLastName());
        assertEquals(this.getEmail(),cuReqBody.getEmail());

    }

}
