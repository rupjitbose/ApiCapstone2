package blogs;

import blogs.create.CreateBlogPostResquestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BlogClient {

    public Response create(CreateBlogPostResquestBody body) {
        Response response = given()
                .header("app-id", "63b7f58f61cc2870a39aa26f")
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("https://dummyapi.io/data/v1/post/create");
        response.then().log().all();
        return response;
    }

    public Response getByID(String id) {
        Response response = given()
                .header("app-id", "63b7f58f61cc2870a39aa26f")
                .pathParam("id", id)
                .when().get("https://dummyapi.io/data/v1/post/{id}");
        response.then().log().body();
        return response;
    }


    public Response deleteByID(String id) {
        Response response = given()
                .header("app-id", "63b7f58f61cc2870a39aa26f")
                .pathParam("id", id)
                .when().delete("https://dummyapi.io/data/v1/post/{id}");
        response.then().log().body();
        return response;
    }
}
