package tests;

import pages.HomePage;
import pages.PageBase;
import org.testng.annotations.*;

public class HomeTest extends TestBase {

	HomePage HomeObject;

	@Test
	public void Test()
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenMenuItem();
	}
}
