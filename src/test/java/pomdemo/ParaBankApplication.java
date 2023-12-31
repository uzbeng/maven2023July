package pomdemo;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import page_objects.AccountDetailsPage;
import page_objects.LoginPage;

public class ParaBankApplication extends Base {	

	private String accntNum = "23001";
	private String accntType = "CHECKING";
	private String accntBalance = "$1000.00";
	

	@Test
	public void testLogin() throws InterruptedException {
		driver.get(properties.getProperty("application.url.qa"));

		LoginPage loginPage = new LoginPage(driver);
		AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);

		loginPage.insertUsername(properties.getProperty("username"));		
		loginPage.insertPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();

		// Verify logged in successfully
		Assert.assertTrue(accountDetailsPage.isLogoutDisplayed());
		assertEquals(accountDetailsPage.getAccountNumber(), accntNum);

		// Open the account details
		accountDetailsPage.openAccountDetails();

		// Check account type:
		wait.until(ExpectedConditions.textToBePresentInElement(accountDetailsPage.getAccountTypeElement(), "CHECKING"));

		Assert.assertEquals(accountDetailsPage.getAccountTypeValue(), accntType);		
		Assert.assertEquals(accountDetailsPage.getAccountBalance(), accntBalance);
	}

}
