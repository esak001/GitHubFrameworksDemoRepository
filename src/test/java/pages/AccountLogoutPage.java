package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogoutPage {
	
	WebDriver driver;
	
	public AccountLogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	public boolean checkForLoginOption() {
		clickOnMyAccountDropMenu();
		return displayStatusOfLoginOption();
	}
	
	public void clickOnMyAccountDropMenu() {
		myAccountDropMenu.click();
	}
	
	public boolean displayStatusOfLoginOption() {
		return loginOption.isDisplayed();
	}

}
