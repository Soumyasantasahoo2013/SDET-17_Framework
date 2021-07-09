package practice.Test;

import java.util.Date;

import org.testng.annotations.Test;

public class Sample1 {
	
	@Test
	public void currentDate()
	{
		String currentSysDate=new Date().toString().replace(":", "_").replace(" ", "_");
	}

}
