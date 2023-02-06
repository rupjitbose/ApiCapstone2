package users;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.DataProperties;
import users.create.CreateUserRequestBody;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UserClient {
    DataProperties dataProperties=new DataProperties();

    public Response create(CreateUserRequestBody body) throws IOException {
        Response response = given()
                .header("app-id", dataProperties.getProperty("app-id"))
                .contentType(ContentType.JSON)
                .body(body)
                .filter(new AllureRestAssured())
                .when().post("https://dummyapi.io/data/v1/user/create");
        response.then().log().body();
        return response;
    }

    public Response getAll(String queryParamName, int queryParamValue) throws IOException {
        Response response = given()
                .header("app-id", dataProperties.getProperty("app-id"))
                .queryParam(queryParamName, queryParamValue)
                .filter(new AllureRestAssured())
                .when().get("https://dummyapi.io/data/v1/user");
        response.then().log().body();
        return response;
    }

}
