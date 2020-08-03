package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[@pvh-data='6']")
	WebElement parentMenu;

	@FindBy(xpath = "//a[@href='https://uk.tommsy.com/womens-dresses-jumpsuits']")
	WebElement subMenu;

	@FindBy(xpath = "//button[@class='cookie-notice__agree-button button']")
	WebElement acceptCookies;

	@FindBy(xpath = "//div[@class='product-list']")
	List<WebElement> productList;

	public void OpenMenuItem() {
		ClickButton(acceptCookies);
		

		for (WebElement product : productList)
		{
			System.out.println( "The list size is " + product.getAttribute("href"));
		}
	}
}
