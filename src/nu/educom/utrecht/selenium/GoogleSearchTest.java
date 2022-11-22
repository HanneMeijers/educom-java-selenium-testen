/**
 * 
 */
package nu.educom.utrecht.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author jwhee
 *
 */
public class GoogleSearchTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver  = new FirefoxDriver();
		driver.navigate().to("http://google.com");
		String appTitle = driver.getTitle();
		System.out.println("Application title is :: "+appTitle);
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("Corona");
		
		driver.quit();
	}

}
