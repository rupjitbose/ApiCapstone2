package blogs;

import blogs.create.CreateBlogPostResquestBody;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.DataProperties;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class BlogClient {


    DataProperties dataProperties=new DataProperties();
    public Response create(CreateBlogPostResquestBody body) throws IOException {
        Response response = given()
                .header("app-id", dataProperties.getProperty("app-id"))
                .contentType(ContentType.JSON)
                .body(body)
                .filter(new AllureRestAssured())
                .when().post(dataProperties.getProperty("base-uri")+"/post/create");
        response.then().log().all();
        return response;
    }

    public Response getByID(String id) throws IOException {
        Response response = given()
                .header("app-id", dataProperties.getProperty("app-id"))
                .pathParam("id", id)
                .filter(new AllureRestAssured())
                .when().get(dataProperties.getProperty("base-uri")+"/post/{id}");
        response.then().log().body();
        return response;
    }


    public Response deleteByID(String id) throws IOException {
        Response response = given()
                .header("app-id", dataProperties.getProperty("app-id"))
                .pathParam("id", id)
                .filter(new AllureRestAssured())
                .when().delete(dataProperties.getProperty("base-uri")+"/post/{id}");
        response.then().log().body();
        return response;
    }
}
