package practice.Test;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

public class SampleTest1{
	
	@Test(retryAnalyzer = com.crm.comcast.GenericUtils.RetryAnalyzer.class)
	public void connectNet() {
		System.out.println(10/0);
	}

}
