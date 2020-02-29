package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="middle_name")
	WebElement middleName;
	
	@FindBy(xpath = "//div[contains(text(),'Create New Contact')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//div[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div[@class='field']/div[@role='combobox']/input")
	WebElement company;
	
	@FindBy(xpath = "//div[@id='dashboard-toolbar']/div[2]/div/button[2]")
	WebElement saveBtn;
	
	
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void createNewContact(String ftName, String ltName, String comp){
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	
	

}
