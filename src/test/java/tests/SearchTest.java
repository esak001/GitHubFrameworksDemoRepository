package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.LandingPage;
import pages.SearchPage;

public class SearchTest extends Base {

	public WebDriver driver;
	LandingPage landingPage;
	SearchPage searchPage;
	
	@BeforeMethod
	public void setup() {
		
		new SearchTest();
		driver = openApplicationURLInBrowser(prop.getProperty("browser"));
		landingPage = new LandingPage(driver);
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void verifySearchingForExisitingProduct() {
		
		searchPage = landingPage.searchProduct(prop.getProperty("existingproduct"));
				
		searchPage = new SearchPage(driver);
		Assert.assertTrue(!searchPage.displayStatusOfProduct());
		
	}
	
	@Test(priority=2,enabled=false)
	public void verifySearchingForNonExistingProduct() {
	
		searchPage = landingPage.searchProduct(prop.getProperty("nonexistingproduct"));
	
		String expectedMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchPage.getSearchResultsMessage(), expectedMessage);
		
	}
	
	@Test(priority=3,dependsOnMethods="verifySearchingForExisitingProduct")
	public void verifySearchingWithoutAnyProduct() {
		
		searchPage = landingPage.searchProduct("");
	
		String expectedMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchPage.getSearchResultsMessage(), expectedMessage);
		
	}

}
