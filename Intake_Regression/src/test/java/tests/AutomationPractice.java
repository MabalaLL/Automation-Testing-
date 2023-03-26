package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class AutomationPractice {
	@AfterTest
	public void teardown() {
		driver.close();
	}
	public static WebDriver driver;
	@Test
    public static void assessment() throws InterruptedException {
        // Set up Chrome driver
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        //WebDriver driver = new ChromeDriver();
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
        
        // Navigate to the web page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        // Radio buttons
        WebElement radioButton3 = driver.findElement(By.xpath("//input[@value='radio3']"));
        radioButton3.click();
        List<WebElement> checkedRadioButtons = driver.findElements(By.xpath("//input[@type='radio' and @checked='checked']"));
        if (checkedRadioButtons.size() == 1 && checkedRadioButtons.get(0).equals(radioButton3)) {
            System.out.println("Validation for radio button 3 passed.");
        } else {
            System.out.println("Validation for radio button 3 failed.");
        }
        
        WebElement radioButton2 = driver.findElement(By.xpath("//input[@value='radio2']"));
        radioButton2.click();
        checkedRadioButtons = driver.findElements(By.xpath("//input[@type='radio' and @checked='checked']"));
        if (checkedRadioButtons.size() == 1 && checkedRadioButtons.get(0).equals(radioButton2)) {
            System.out.println("Validation for radio button 2 passed.");
        } else {
            System.out.println("Validation for radio button 2 failed.");
        }
        
        // Type in the field 'South' and select 'South Africa' from the list of options
        WebElement autoComplete = driver.findElement(By.id("autocomplete"));
        autoComplete.sendKeys("South");
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(autoComplete).perform();
        WebElement southAfricaOption = driver.findElement(By.xpath("//li[@class='ui-menu-item' and descendant::div[text()='South Africa']]"));
        southAfricaOption.click();
        
        // Clear the field and type 'Republic' and select the first option listed
        autoComplete.clear();
        autoComplete.sendKeys("Republic");
        Thread.sleep(1000);
        actions.moveToElement(autoComplete).perform();
        WebElement firstOption = driver.findElement(By.xpath("//li[@class='ui-menu-item'][1]"));
        firstOption.click();
        
        // Checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
        List<WebElement> checkedCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @checked='checked']"));
        if (checkedCheckboxes.size() == checkboxes.size()) {
            System.out.println("Validation for all checkboxes passed.");
        } else {
            System.out.println("Validation for all checkboxes failed.");
        }
        
        WebElement firstCheckbox = checkboxes.get(0);
        firstCheckbox.click();
        checkedCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @checked='checked']"));
        if (checkedCheckboxes.size() == checkboxes.size() - 1 && !checkedCheckboxes.contains(firstCheckbox)) {
            System.out.println("Validation for unchecking first checkbox passed.");
        } else {
            System.out.println("Validation for unchecking first checkbox failed.");
        }
        
        // Show / hide
        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        //WebElement textBox = driver.findElement(By.id("displayed-textbox"));

}
}
