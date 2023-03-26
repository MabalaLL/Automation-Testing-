package test;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class browser {
	
	public static WebDriver driver; 
	public static Properties properties= new Properties();
	public static FileReader inputstrean;
	@BeforeTest
	public void launch() throws IOException{
		
		if(driver==null) {
			
			FileReader inputstrean= new FileReader("C:\\Users\\KING LEFA\\eclipse-workspace\\Intake_Regression\\src\\test\\resources\\properties\\testData.properties");
	        properties.load(inputstrean);
	        
		} 
		
		if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   driver.get(properties.getProperty("url"));
		   driver.manage().window().maximize();
		
		}else if(properties.getProperty("browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(properties.getProperty("url"));
			driver.manage().window().maximize();
			
		}
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
	

}
