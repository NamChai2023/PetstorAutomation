package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 {
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void stupData()
	{
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
     	userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority=1)
	
	public void testPostUser()
	{
		Response response=Userendpoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

@Test(priority=2)
	
	public void testGetUserByname()
	{
		Response response=Userendpoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
/*@Test(priority=3)

public void testUpdateUserByname()
{
	
	userPayload.setFirstName(faker.name().firstName());
	userPayload.setLastName(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	
	Response response=Userendpoints2.updateUser(this.userPayload.getUsername(),userPayload);
	response.then().log().body();
	Assert.assertEquals(response.getStatusCode(), 200);
	Response responseAfterUpdate=Userendpoints2.readUser(this.userPayload.getUsername());
	responseAfterUpdate.then().log().all();
	Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	
	
}*/

@Test(priority=3)

public void testDeleteUser()

{
	Response response=Userendpoints2.deletedUser(this.userPayload.getUsername());
	response.then().log().body();
	Assert.assertEquals(response.getStatusCode(), 200);
}
}



