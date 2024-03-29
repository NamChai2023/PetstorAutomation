package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class Userendpoints {
	public static Response createUser(User payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.post(Routes.post_url);
		return response;
				
	}
	
	
	public static Response readUser(String userName)
	{
		Response response=given()
			.pathParam("username",userName)
			.when()
			.get(Routes.get_url);
		return response;
				
	}
	
	public static Response updateUser(String userName,User payload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			     .pathParam("username",userName)
			     .when()
			.put(Routes.update_url);
		return response;
				
	}
	
	public static Response deletedUser(String userName)
	{
		Response response=given()
			.pathParam("username",userName)
			.when()
			.delete(Routes.delete_url);
		return response;
				
	}
				
	
}