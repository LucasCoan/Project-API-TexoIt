import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class restApiTest {

    @Test
    public void RequestGet() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[3].email", equalTo("Lew@alysha.tv"));

    }

    @Test
    public void RequestPost() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .post("https://jsonplaceholder.typicode.com/users")
                .then()
                .assertThat()
                .statusCode(201)
                .body("id", equalTo(11));
    }

    @Test
    public void RequestPut() {
        given()
                .when()
                .header("email", "lucas.coan@gmail.com")
                .header("lat", "00.000")
                .header("lng", "00.000")
                .put("https://jsonplaceholder.typicode.com/users/5")
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", equalTo(5));
    }
}
