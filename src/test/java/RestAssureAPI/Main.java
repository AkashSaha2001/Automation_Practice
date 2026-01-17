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

        String response= given().log().all().queryParam("key","qaclick800").body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -108.383494,\n" +
                        "    \"lng\": 108.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Sweet house\",\n" +
                        "  \"phone_number\": \"(+91) 1234569870\",\n" +
                        "  \"address\": \"Kolkata\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"Hindi-IN\"\n" +
                        "}")
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))

                .extract().response().toString();

        System.out.println(response);
        System.out.println("---------------------------------------------------------");

        JsonPath js=new JsonPath(response);
        String placeId=js.getString("place_id");
        System.out.println("Place ID is : "+placeId);

    }
}

/*

Request Header --------------->

Request method:	POST
Request URI:	https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick800
Proxy:			<none>
Request params:	<none>
Query params:	key=qaclick800
Form params:	<none>
Path params:	<none>
Headers:		Accept=*
Content-Type=text/plain; charset=ISO-8859-1
Cookies:		<none>
Multiparts:		<none>

Request Body------------------------------>

Body:
        {
        "location": {
        "lat": -108.383494,
        "lng": 108.427362
        },
        "accuracy": 50,
        "name": "Sweet house",
        "phone_number": "(+91) 1234569870",
        "address": "Kolkata",
        "types": [
        "shoe park",
        "shop"
        ],
        "website": "http://google.com",
        "language": "Hindi-IN"
        }


Response Header-------------------------------->

HTTP/1.1 200 OK
Date: Sat, 17 Jan 2026 13:39:29 GMT
Server: Apache/2.4.52 (Ubuntu)
Access-Control-Allow-Origin: *
Access-Control-Allow-Methods: POST
Access-Control-Max-Age: 3600
Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With
Content-Length: 194
Keep-Alive: timeout=5, max=100
Connection: Keep-Alive
Content-Type: application/json;charset=UTF-8


Response Body---------------------------------->

        {
        "status": "OK",
        "place_id": "bc9c61128d34bfcdcacca51a712d1c4c",
        "scope": "APP",
        "reference": "2215652e51c686871abbd6ddadf679ef2215652e51c686871abbd6ddadf679ef",
        "id": "2215652e51c686871abbd6ddadf679ef"
        }
 */
