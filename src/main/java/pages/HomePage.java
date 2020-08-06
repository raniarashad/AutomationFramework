package pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.sql.rowset.spi.XmlReader;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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
		Driver = driver;

	}

	JavascriptExecutor js;	
	WebDriver Driver;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	@FindBy(xpath = "//button[@class='cookie-notice__agree-button button']")
	WebElement acceptCookies;

	public void OpenMenuItem() throws IOException {

		ClickButton(acceptCookies);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("begin");

		System.out.println("Please enter the Class Name : ");
		String selector = reader.readLine();
		List <WebElement> ImageTag  = (List<WebElement>) Driver.findElements(By.className(selector));
		
		System.out.println("Please Enter the File Path that data will be saved in : ");
		String FilePath = reader.readLine();
		File source  = new File(FilePath);

		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i <ImageTag.size(); i++) 
		{ 
			String list = ImageTag.get(i).getAttribute("href");
			js.executeScript("window.scrollBy(0,2000)");

			try 
			{
				Thread.sleep(4000); 
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace(); 
			}

			FileInputStream input = new FileInputStream(source);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sheet = wb.getSheetAt(0);
			sheet.createRow(i).createCell(0).setCellValue(list);
			FileOutputStream output = new FileOutputStream(source);
			wb.write(output);
			wb.close();
		}
	}

	public void WriteInTextFile () {

		//Create File In D: Driver.  
		String TestFile = "D:\\Rania\\Automation Projects\\Scrapping.data\\src\\test\\java\\utilities\\temp.txt";
		File FC = new File(TestFile);//Created object of java File class.
		try {
			FC.createNewFile();
			FileWriter FW = new FileWriter(TestFile);
			BufferedWriter BW = new BufferedWriter(FW);
			BW.write("This Is First Line."); //Writing In To File.
			BW.newLine();//To write next string on new line.
			BW.write("This Is Second Line."); //Writing In To File.
			BW.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Create file.

		//Writing In to file.
		//Create Object of java FileWriter and BufferedWriter class.

	}

	public void WriteTextInExcel () throws IOException {

		File source  = new File("D:\\Rania\\Automation Projects\\Scrapping.data\\src\\test\\java\\utilities\\Data.xlsx");
		FileInputStream input = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheetAt(0);
		sheet.createRow(0).createCell(0).setCellValue("Pass1");
		sheet.createRow(1).createCell(0).setCellValue("Pass2");
		sheet.createRow(2).createCell(0).setCellValue("pass3");
		FileOutputStream output = new FileOutputStream(source);
		wb.write(output);
		wb.close();

	}
}


