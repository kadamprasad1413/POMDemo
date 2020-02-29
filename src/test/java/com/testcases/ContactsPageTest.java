
package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.crm.qa.util.TestUtil;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	   
	public ContactsPageTest(){
			super();
			
	}
		
	//@BeforeMethod
	@Test(priority=1)
	public void setUp() throws InterruptedException, IOException {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		TestUtil.takeScreenshot("ClickOnContactsLink");
	}
	
	@Test(priority=2)
	public void verifyContactsPageLabel() throws IOException{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
		TestUtil.takeScreenshot("VerifyContactsPageLable");
	}

	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String company) throws IOException{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(firstName, lastName, company);
		TestUtil.takeScreenshot("CreateNewContact");
	}
	
	

	//@AfterMethod
	@Test(priority=4)
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
