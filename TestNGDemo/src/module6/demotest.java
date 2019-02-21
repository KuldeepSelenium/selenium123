package module6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class demotest {
	
	WebDriver driver;
	@Test
	public void EnterData() {
		System.out.println("in test");
		driver.findElement(By.id("ts_first_name")).sendKeys("Abhresh");

		driver.findElement(By.name("ts_last_name")).sendKeys("Sugandhi");

		driver.findElement(By.name("ts_address")).sendKeys("Pune, Maharashtra, India");

		driver.findElement(By.name("ts_checkbox1")).click();

		driver.findElement(By.name("Submit1")).click();
	}

	@BeforeTest
	public void OpenAUT() {
		System.out.println("in before test");
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\\\\\\\Edureka_Selenium\\\\\\\\ExEFiles\\\\\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/automation-testing-sample_28.html");
		
	}

	@AfterSuite
	public void CloseBrowser() {
		driver.close();
	}
}
