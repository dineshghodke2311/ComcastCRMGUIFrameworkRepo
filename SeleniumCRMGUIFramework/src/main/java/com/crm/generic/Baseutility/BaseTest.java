package com.crm.generic.Baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("execute beforesuite") ;
	}

	@BeforeClass
	public void beforeclass()
	{
		System.out.println("execute beforeclass") ;
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("execute beforemethod") ;
	}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("execute aftermethod") ;
	}
	
	
    @AfterClass
	public void afterclass()
	{
		System.out.println("execute afterclass") ;
	}

	
	
	
	
	
	
	
	
	
	
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("execute aftersuite") ;
	}
	
	

}
