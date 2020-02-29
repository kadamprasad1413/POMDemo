package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'laxman gore')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//div[@id='dashboard-toolbar']//a[@href='/contacts/new']/button")
	WebElement newContactLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
		
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() throws InterruptedException{
		Thread.sleep(3000);
		driver.navigate().to("https://ui.freecrm.com/contacts");
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink(){
		newContactLink.click();
	}
	
}
