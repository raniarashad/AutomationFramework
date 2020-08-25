package tests;

import pages.HomePage;

import java.io.IOException;

import org.testng.annotations.*;

public class HomeTest extends TestBase {

	HomePage HomeObject;

	@Test
	public void Test()
	{
		HomeObject = new HomePage(driver);
		try {
			HomeObject.OpenMenuItem();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	/*	try {
			HomeObject.WriteTextInExcel();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
}
