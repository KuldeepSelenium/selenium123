package com.edureka.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownIndigo {

	public static void main(String[] args) {

		System.setProperty("Webdriver.chrome.driver", "D:\\Edureka_Selenium\\ExEFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);

		// Getting Application under AUT
		driver.get("https://www.goindigo.in/");

		
	}

}
