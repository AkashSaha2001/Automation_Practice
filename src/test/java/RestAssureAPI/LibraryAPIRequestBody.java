package RestAssureAPI;

public class LibraryAPIRequestBody {

    public static String RequestBody(String bookname,String bookID){
        String body="{\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+bookname+"\",\n" +
                "\"aisle\":\""+bookID+"\",\n" +
                "\"author\":\"Akash Saha\"\n" +
                "}\n";

        return body;
    }
}
