import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasKey;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.junit.Test;


public class allDogBreeds {

    public RequestSpecification requestSpec;
    public ResponseSpecification responseSpec;

    @Before
    public void BeforeSetup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://dog.ceo/api/")
                .setContentType(ContentType.JSON)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;

    }

    @Test
    public void getAllBreed() {
        given()
                .header("Accept", "application/json")
                .when()
                .get("breeds/list/all")
                .then()
                .assertThat()
                .contentType("application/json")
                .log().all()
                .statusCode(200)
                .body("message", hasKey("retriever"));
                 System.out.println();
    }



    @Test
    public void SubBreeds(){

       given() .header("Accept", "application/json")
                .when()
                .get("breed/retriever/list")
                .then()
                .assertThat()
                .contentType("application/json")
                .log().all()
                .statusCode(200);


    }


    @Test

    public void RandomImage(){
        given()
                .header("Accept", "application/json")
                .when()
                .get("breed/retriever/golden/images/random")
                .then()
                .assertThat()
                .contentType("application/json")
                .log().all()
                .statusCode(200);


    }
}