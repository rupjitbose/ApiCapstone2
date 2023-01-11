package users.create;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestBody {
    private String firstName;
    private String lastName;
    private String email;

    public CreateUserRequestBody(Builder builder) {
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.email=builder.email;
    }
    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;

        public Builder(){
            this.firstName="rupjit";
            this.lastName="bose";
            this.email= UUID.randomUUID() + "@gmail.com";
        }
        public Builder email(String email){
            this.email=email;
            return this;
        }
        public CreateUserRequestBody build(){
            CreateUserRequestBody createUsersRequestBody = new CreateUserRequestBody(this);
            return createUsersRequestBody;
        }
    }
}
