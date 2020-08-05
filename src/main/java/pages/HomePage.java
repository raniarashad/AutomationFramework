package pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.JavascriptExecutor;
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
		js = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//li[@pvh-data='6']")
	WebElement parentMenu;

	@FindBy(xpath = "//a[@href='https://uk.tommsy.com/womens-dresses-jumpsuits']")
	WebElement subMenu;

	@FindBy(xpath = "//button[@class='cookie-notice__agree-button button']")
	WebElement acceptCookies;

	@FindBy(xpath = "//div[@class='product-list']")
	List<WebElement> productList;

	@FindBy(className ="product-image__image")
	List<WebElement> productImage;
	
	@FindBy(className = "product-tile__imagery")
	List<WebElement> Tag_a_ToGetHref;

	JavascriptExecutor js;

	public void OpenMenuItem() {

		ClickButton(acceptCookies);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("begin");


		for (int i = 0; i <Tag_a_ToGetHref.size(); i++) 
		{ 
			String list = Tag_a_ToGetHref.get(i).getAttribute("href");

			js.executeScript("window.scrollBy(0,2000)");

			try 
			{
				Thread.sleep(20000); 
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace(); 
			}

			System.out.println(list);

		}


	}
}
