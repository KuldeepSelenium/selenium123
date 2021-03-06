package com.edureka.com;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class testCaseNaukri {

	public static void main(String[] args) {
		// Initialize browser
		System.setProperty("WebDriver.chrome.driver", "D:\\\\bEdureka_Selenium\\\\ExEFiles\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.naukri.com/");
		
		WebElement MH = driver.findElement(By.xpath("//div[@class = 'mTxt' and text()='Services']"));

		Actions act = new Actions(driver);
		
		act.moveToElement(MH).build().perform();
	
		boolean Getoption = driver.findElement(By.xpath("//*[text()='Resume Writing']")).isEnabled();
		System.out.println(Getoption);
		
		List<WebElement> ListOp = driver.findElements(By.xpath("//li[@class=\"''\"]//div[@class='subMenu c3']//ul[1]"));
		int size = ListOp.size();
		System.out.println(size);
		
		Iterator<WebElement> count = ListOp.iterator();
		while (count.hasNext()) {
			System.out.println(count.next().getAttribute("title"));
		}
		
		
		
	}

}
