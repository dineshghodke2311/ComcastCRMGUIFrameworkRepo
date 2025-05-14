package practice_testng_annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.Baseutility.BaseTest;

public class Practice_ConfigurationsAnnotationsTest extends BaseTest {

	

	@Test
	public void Sample1Test()
	{

		System.out.println("execute sample1Test") ;
	}

    @Test
	public void Sample2Test()
	{

		System.out.println("execute sample2Test") ;
	}

}
