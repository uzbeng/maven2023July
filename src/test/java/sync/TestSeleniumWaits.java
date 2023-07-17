package sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestSeleniumWaits {
	
	protected WebDriver driver = null;
	protected WebDriverWait wait;
	private long implicitTime = 20;
	private long explicitTime = 30;

	@BeforeMethod
	public void setup() {

		String browser = "chrome";

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\webdrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		// Move the window to the left side:
		driver.manage().window().setPosition(new Point(-1800, 0));
		driver.manage().window().maximize();
		
		// Implicit wait:
		// Does not throw <No Such Element Exception> before the set time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTime));
		
		// Create explicit wait:
		wait = new WebDriverWait(driver, Duration.ofSeconds(explicitTime));
	}

	// @Test
	public void alertDelay() {
		driver.get("file:///C:/Users/Jurabek/OneDrive/Desktop/waits.html");

		// 1. Delayed Alert:
		driver.findElement(By.id("alert")).click();
		// I need wait here:
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	// @Test
	public void textMsg() {

		driver.get("file:///C:/Users/Jurabek/OneDrive/Desktop/waits.html");
		driver.findElement(By.id("populate-text")).click();

		// Wait here:
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("h2")), "Selenium Webdriver"));
		String text = driver.findElement(By.id("h2")).getText();

		Assert.assertEquals(text, "Selenium Webdriver");
	}

	// @Test
	public void hiddenButton() {

		driver.get("file:///C:/Users/Jurabek/OneDrive/Desktop/waits.html");
		driver.findElement(By.id("display-other-button")).click();

		// Wait here:
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));

		driver.findElement(By.id("hidden")).click();

	}

	// @Test
	public void enableButton() {
		driver.get("file:///C:/Users/Jurabek/OneDrive/Desktop/waits.html");
		driver.findElement(By.id("enable-button")).click();

		// Wait until button becomes enabled:
		wait.until(ExpectedConditions.elementToBeClickable(By.id("disable")));
		driver.findElement(By.id("disable")).click();

	}

	//@Test
	public void elementIsSelected() {
		driver.get("file:///C:/Users/Jurabek/OneDrive/Desktop/waits.html");
		driver.findElement(By.id("checkbox")).click();

		// Wait until button becomes enabled:
		wait.until(ExpectedConditions.elementToBeSelected(By.id("ch")));
		
		Assert.assertTrue(driver.findElement(By.id("ch")).isSelected());

	}

}
