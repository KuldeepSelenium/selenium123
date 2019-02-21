package module6;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseChildWindow {
	@Test
	public void f() throws InterruptedException {

		System.getProperty("WebDriver.chrome.driver", "D:\\Edureka_Selenium\\ExEFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		Thread.sleep(3000);

		String ParentWindow = driver.getWindowHandle();
		System.out.println("Parent Window is " + ParentWindow);

		driver.findElement(By.xpath("//*[contains(text(),'New Browser Window')]")).click();
		Thread.sleep(3000);

		Set<String> allWindowHandles = driver.getWindowHandles();
		
		String currentwin = allWindowHandles.iterator().next();
		System.out.println(currentwin);
		
		allWindowHandles.remove(allWindowHandles.iterator().next());
		
		String nextwin = allWindowHandles.iterator().next();
		System.err.println(nextwin);
		
		driver.switchTo().window(nextwin).close();;

}}
