package com.edureka.com;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class FwaitForAmazon {

	@SuppressWarnings("unused")
	private static WebElement element;

	public static void main(String[] args) {
	
		System.getProperty("WebDriver.chrome.driver", "D:\\\\Edureka_Selenium\\\\ExEFiles\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50000,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in");
		driver.findElement(By.linkText("Today's Deals")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
		
		element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.partialLinkText("LinkText-4"));
				element.click();
					return element;
			}
			});
		
		
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='dealImage']"));
		System.out.println(list.size());
		
		Iterator<WebElement> itr = list.iterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next().getAttribute("href"));
			
		}
		
		
		
		
	}

}
