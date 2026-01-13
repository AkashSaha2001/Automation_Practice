package RestAssureAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Main {
    public static void main(String args[]){
        RestAssured.baseURI="https://rahulshettyacademy.com";



//        Post request -->

        String response= given().log().all().queryParam("key","qaclick123").body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}")
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))

                .extract().response().toString();

        System.out.println(response);

        JsonPath js=new JsonPath(response);
        String placeId=js.getString("place_id");
        Assert.assertEquals(placeId,"595766a5e949b32453ecc0f2eb4cca6f");


    }
}
