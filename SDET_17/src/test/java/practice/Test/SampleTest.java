package practice.Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

@Listeners(com.crm.comcast.GenericUtils.ListImpClass.class)
public class SampleTest extends BaseClass{
	
	//@Test
	public void createOrg()
	{
		System.out.println("execute createorg test");
		System.out.println(10/0);
	}
	
	@Test
	public void createOrgWithIndustry()
	{
		System.out.println("execute createorgWithIndustry test");
		System.out.println(10/0);
	}

}
