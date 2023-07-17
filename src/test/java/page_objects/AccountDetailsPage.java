package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountDetailsPage {
	
	private WebDriver driver;
	
	By logoutLink = By.xpath("//a[text()='Log Out']");
	By accountNumberLink = By.xpath("//table[@id='accountTable']/tbody/tr[1]/td[1]/a");
	By accountTypeBox = By.cssSelector("td[id=accountType]");
	By accountBalance = By.id("balance");
	
	
	public AccountDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogout() {
		driver.findElement(logoutLink).click();
	}
	
	public boolean isLogoutDisplayed() {
		List<WebElement> logoutElements = driver.findElements(logoutLink);
		return logoutElements.size() > 0;
	}
	
	public String getAccountNumber() {
		return driver.findElement(accountNumberLink).getText();
	}
	
	public void openAccountDetails() {
		driver.findElement(accountNumberLink).click();
	}
	
	public WebElement getAccountTypeElement() {
		return driver.findElement(accountTypeBox);
	}
	
	public String getAccountTypeValue() {
		return driver.findElement(accountTypeBox).getText();
	}
	
	public String getAccountBalance() {
		return driver.findElement(accountBalance).getText();
	}

}
