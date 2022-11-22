/**
 * 
 */
package nu.educom.utrecht.selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author jwhee
 *
 */
class TestMainWebsite {

	private static final String MAIN_URL = "http://localhost/educom-webshop-oop/";
	
	static WebDriver driver;

	/**
	 * Do before each @Test
	 */
	@BeforeEach
	void setUp() throws Exception {
		driver.navigate().to(MAIN_URL);
	}

	@Test
	void testShowHome() {
		WebElement homeButton = driver.findElement(By.linkText("Home"));
		assertNotNull(homeButton, "No Home button found");
	}

	@Test
	void testNavigateToAbout() {
		WebElement aboutButton = driver.findElement(By.cssSelector("a[href='index.php?page=about']"));
		aboutButton.click();
		
		WebElement aboutHeader = driver.findElement(By.tagName("h1"));
		assertEquals("Over Mij", aboutHeader.getText());
	}

	@Test
	void testNavigateToContact_SubmitEmptyValues() {
		WebElement thirdMenuButton = driver.findElements(By.cssSelector("ul li")).get(2);
		thirdMenuButton.click();
		
		WebElement submitButton = driver.findElement(By.cssSelector("input[type=submit]"));
		submitButton.click();
		
		List<WebElement> errors = driver.findElements(By.className("error"));
		assertNotNull(errors);
		assertTrue(errors.size() > 1);
		assertEquals("Aanhef is verplicht", errors.get(1).getText().trim());
	}
	
	
	/*  More tests here */
	
	
	
	

	/* Administration */
	/**
	 * Do before any tests have run
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
	}

	/**
	 * Do after all tests are run
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
