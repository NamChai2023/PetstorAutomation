package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	public Logger logger;
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	
	public void testPostuser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph)	
	{
       User userPayload=new User();
       userPayload.setId(Integer.parseInt(userID));
       userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		logger=LogManager.getLogger(this.getClass());
		logger.info("**********Post user**********");
		Response response=Userendpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********Posted user**********");
	
}
	
	@Test(priority=1,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	
	public void testDeleteUserByname(String userName)
	{
		logger=LogManager.getLogger(this.getClass());
		logger.info("**********Delete user**********");
		Response response=Userendpoints.deletedUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********Deleted user**********");
	}
	

	
	

}

