package practice_asserts;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AsssertTest {

	@Test
	public void sampleTest1(Method mtd)
	{
		Reporter.log(mtd.getName()+"Test Start",true);

		Reporter.log("Step 1",true);
		Reporter.log("Step 2",true);

		// hard assert
		Assert.assertEquals("Home","Home");
		Reporter.log("Step 3");
		SoftAssert assertobj = new SoftAssert();
		assertobj.assertEquals("Title","Title1");
		Reporter.log("Step 4",true);
		assertobj.assertAll();
		Reporter.log(mtd.getName()+"Test End",true);
	}
	
	@Test
	public void sampleTest2(Method mtd)
	{
		Reporter.log(mtd.getName()+"Test Start",true);

		Reporter.log("Step 1",true);
		Reporter.log("Step 2",true);
		SoftAssert assertobj = new SoftAssert();
		assertobj.assertTrue(true);
        Reporter.log("Step 3",true);

        Reporter.log("Step 4",true);
		assertobj.assertAll();
		Reporter.log(mtd.getName()+"Test End",true);
	}



}
