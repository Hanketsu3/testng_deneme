package testng_deneme;

import org.testng.annotations.*;

public class testngtest {
	@BeforeTest
	public void BeforeTest() {
		System.out.println("Before Test");
	}
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("Before Suite");
	}
	@BeforeClass
	public void BeforeClass() {
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("Before Method");
	}
	@Test
	public void test1() {
		
	}
	@AfterMethod
	public void AfterMethod() {
		System.out.println("After Method");
	}
	
}
