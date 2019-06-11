package shopping_Test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Shopping {
	WebElement we;
	static WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	static Actions action;
	

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);
	}

	@AfterClass
	public static void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();

	}
	@Test
	public void mthodTest() throws InterruptedException {
		driver.get(url);
		we = driver.findElement(
				By.xpath("//*[@id=\"search_query_top\"]"));
		we.sendKeys("Dress");
		we.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
//		action.sendKeys(Keys.PAGE_DOWN).perform();
		we = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));
		action.moveToElement(we).perform();
		we = driver.findElement(
				By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[2]/span"));
//		while (!we.isDisplayed()) {
//			action.sendKeys(Keys.PAGE_DOWN);	
//		}
		we.click();
		
		we = driver.findElement(
				By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		we.click();
		Thread.sleep(4000);
		
		we = driver.findElement(
				By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		we.click();
			
//		action.sendKeys(Keys.PAGE_DOWN).perform();
		we = driver.findElement(
				By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
		action.moveToElement(we).click().perform();
//		Thread.sleep(1000);
		WebElement we2 = driver.findElement(
				By.xpath("//*[@id=\"center_column\"]/h1"));
//		
		assertEquals("AUTHENTICATION",we2.getText());
	}
}
