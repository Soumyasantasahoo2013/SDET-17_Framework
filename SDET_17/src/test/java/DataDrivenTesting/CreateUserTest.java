package DataDrivenTesting;

import org.testng.annotations.Test;

public class CreateUserTest {
	
	@Test
	public void createUserTest()
	{
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		System.out.println("execute Test");
		System.out.println("=======>"+USERNAME);
		System.out.println("=======>"+PASSWORD);
	}

}
