package com.edureka.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchCourse {

	public static void main(String[] args) {

		try {
			// Initiate browser
			System.setProperty("webdriver.driver", "D:\\Edureka_Selenium\\ExEFiles\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			// Get URL
			driver.get("https://www.edureka.co/");

			// Search for course
			driver.findElement(By.id("search-inp")).sendKeys("Selenium");
			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@id=\"search-button-top\"]")).click();

			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Selenium Certification Training')]")));

			driver.findElement(By.xpath("//h3[contains(text(),'Selenium Certification Training')]")).click();
			String pageTitle = driver.getTitle();
			System.out.println(pageTitle);

			if (pageTitle.contains("Selenium")) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test Failed");
			}


			try {

			} finally {
				driver.quit();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}