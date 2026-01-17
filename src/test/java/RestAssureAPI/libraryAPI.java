package RestAssureAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import net.bytebuddy.build.ToStringPlugin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
/*

Created 3 type of sending request
1. Send one request At a Time
2. To send Bulk Request we have to use Data Provided to send as many POST request at a time
3. If we don't want to put the request Body in the code then put it into separate file to make the code look better,
   We can also use data provider at the same time
4. Send the Raw JSON Request body file directly form the code



 */

public class libraryAPI {


    // 1. Send one request At a Time-------------------------->

    @Test
    public void PostRequest() {
        RestAssured.baseURI = "http://216.10.245.166";

        String res = given().log().all().body("{\n" +
                        "\"name\":\"Learn Appium Automation with Java\",\n" +
                        "\"isbn\":\"Book002\",\n" +
                        "\"aisle\":\"002\",\n" +
                        "\"author\":\"Akash Saha\"\n" +
                        "}\n").when().post("Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).extract().response().toString();
        System.out.println(res);
    }


    // 2. To send Bulk Request we have to use Data Provided to send as many POST request at a time---------->

    @Test(dataProvider = "BookData")
    public void BulkPostRequest(String bookName, String bookID) {
        RestAssured.baseURI = "http://216.10.245.166";

        String res = given().log().all().body("{\n" +
                        "\"name\":\"Learn Appium Automation with Java\",\n" +
                        "\"isbn\":\"" + bookName + "\",\n" +
                        "\"aisle\":\"" + bookID + "\",\n" +
                        "\"author\":\"Akash Saha\"\n" +
                        "}\n").when().post("Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).extract().response().toString();
        System.out.println(res);
    }

    @DataProvider(name = "BookData")
    public Object[][] BookData() {
        Object[][] data = {
                {"Book003", "003"},
                {"Book004", "004"},
                {"Book005", "005"}
        };
        return data;
    }

    /*  OutPut-->  :

Request Header 1---------------------------->

Request method:	POST
Request URI:	http://216.10.245.166/Library/Addbook.php
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*
    Content-Type=text/plain; charset=ISO-8859-1
    Cookies:		<none>
    Multiparts:		<none>


    Request Body 1---------------------------->

    Body:
    {
        "name":"Learn Appium Automation with Java",
            "isbn":"Book003",
            "aisle":"003",
            "author":"Akash Saha"
    }

    Response Header 1---------------------------->

    HTTP/1.1 200 OK
    Date: Sat, 17 Jan 2026 14:03:34 GMT
    Server: Apache
    Access-Control-Allow-Origin: *
    Access-Control-Allow-Methods: POST
    Access-Control-Max-Age: 3600
    Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With
    Keep-Alive: timeout=5, max=100
    Connection: Keep-Alive
    Transfer-Encoding: chunked
    Content-Type: application/json;charset=UTF-8


    Response Body 1---------------------------->

    {
        "Msg": "successfully added",
            "ID": "Book003003"
    }

    Same for other 2---->
     */


    // 3. If we don't want to put the request Body in the code then put it into separate file to make the code look better, We can also use data provider at the same time

    @Test(dataProvider = "BookData1")
    public void BulkPostRequest1(String bookName, String bookID) {
        RestAssured.baseURI = "http://216.10.245.166";

        String res = given().log().all().body(LibraryAPIRequestBody.RequestBody(bookName, bookID)).when().post("Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).extract().response().toString();
        System.out.println(res);
    }

    @DataProvider(name = "BookData1")
    public Object[][] BookData1() {
        Object[][] data = {
                {"Book006", "006"},
                {"Book007", "007"},
                {"Book008", "008"}
        };
        return data;
    }

    /*

    Output-->

Request method:	POST
Request URI:	http://216.10.245.166/Library/Addbook.php
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*
    Content-Type=text/plain; charset=ISO-8859-1
    Cookies:		<none>
    Multiparts:		<none>
    Body:
    {
        "name":"Learn Appium Automation with Java",
            "isbn":"Book006",
            "aisle":"006",
            "author":"Akash Saha"
    }

    HTTP/1.1 200 OK
    Date: Sat, 17 Jan 2026 14:13:31 GMT
    Server: Apache
    Access-Control-Allow-Origin: *
    Access-Control-Allow-Methods: POST
    Access-Control-Max-Age: 3600
    Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With
    Keep-Alive: timeout=5, max=100
    Connection: Keep-Alive
    Transfer-Encoding: chunked
    Content-Type: application/json;charset=UTF-8

    {
        "Msg": "successfully added",
            "ID": "Book006006"
    }
     */


    //4. Send the Raw JSON Request body file directly form the code------------------------------->

    @Test
    public void BulkPostRequest2() throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";

        String res = given().log().all().body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Akash Saha\\IdeaProjects\\SeleniumWebDriver\\src\\test\\java\\RestAssureAPI\\LibraryAPI.json"))))
                .when().post("/Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println(res);

        JsonPath js = new JsonPath(res);
        String ID = js.getString("ID");

        System.out.println("BookID is : " + ID);
    }

    /*

    OutPut : --->

Request Header -------------------->

Request method:	POST
Request URI:	http://216.10.245.166/Library/Addbook.php
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*
    Content-Type=text/plain; charset=ISO-8859-1
    Cookies:		<none>
    Multiparts:		<none>


    Request Body----------------------->

    Body:
    {
        "name":"Learn Appium Automation with Java",
            "isbn":"Book009",
            "aisle":"009",
            "author":"Akash Saha"
    }

    Response Header ---------------------->

    HTTP/1.1 200 OK
    Date: Sat, 17 Jan 2026 14:32:33 GMT
    Server: Apache
    Access-Control-Allow-Origin: *
    Access-Control-Allow-Methods: POST
    Access-Control-Max-Age: 3600
    Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With
    Keep-Alive: timeout=5, max=100
    Connection: Keep-Alive
    Transfer-Encoding: chunked
    Content-Type: application/json;charset=UTF-8

Response Body------------------------------->

    {
        "Msg": "successfully added",
            "ID": "Book009009"
    }

    Response ------------------->
    {"Msg":"successfully added","ID":"Book009009"}

    Extraction ----------------->
    BookID is : Book009009
     */


}
