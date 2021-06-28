package DataDrivenTesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateCustomerTest {
	
	@Test
	public void createCustomerTest(XmlTest xml)
	{
		System.out.println("Hii");
		
		String USERNAME=xml.getParameter("username");
		System.out.println(USERNAME);
	}

}
