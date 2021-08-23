package Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TempAPI {

    RequestSpecification httpRequest;
    Response response;
    String url = "http://localhost:3000/";

    @Test
    public void testingAPI() {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin", "admin");

        // Get Request
        response = httpRequest.get("/api/teams/search");

        // Post + Put Request
//        JSONObject params = new JSONObject();
//        params.put("name", "BTeam");
//        params.put("email", "BTeam@kuku.com");
//        httpRequest.header("Content-Type", "application/json");
//        httpRequest.body(params.toJSONString());
        //response = httpRequest.post("/api/teams");

        //response = httpRequest.put("/api/teams/3");

        //response = httpRequest.delete("/api/teams/2");

        response.prettyPrint();
    }



}
