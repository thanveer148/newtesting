package com.comcast.crm.contactNG;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Excel_utility;
import com.comcast.crm.generic.fileutility.File_Utility;
import com.comcast.crm.generic.webdriverutility.Java_Utility;
import com.comcast.crm.generic.webdriverutility.WebDriver_Utility;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OraganizationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.crm.generic.baseUtility.BaseClass;

public class CreateContactTest extends BaseClass {
	@Test(groups="smoketest")
	public void Createcontactlastname() throws Throwable, IOException {
		// read testscript file in EXCEL
		String lastName = elib.getFileFromExcel("sheet2", 1, 2) + jlib.getrandomNumber();
		// click on contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();
		// click on + button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontact().click();

		// step 4: enter all the details and create new organisation
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.getLastname().sendKeys(lastName);
		cip.getConsavebtn().click();

		// verify header orgname info expected result
		String actLastName = cip.getLastnamefield().getText();
		if (actLastName.trim().equals(lastName)) {
			System.out.println(lastName + "is created==PASS");
		} else {
			System.out.println(lastName + "is created==FAIL");
		}
	}

	@Test(groups="regressiontest")
	public void createContactWithSupportingDateTest() throws EncryptedDocumentException, IOException {

		// read testscript file in EXCEL
		String lastname = elib.getFileFromExcel("sheet1", 10, 3) + jlib.getrandomNumber();

		// click on contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// click on + button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontact().click();

		// enter all the details and create new organisation
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.getLastname().sendKeys(lastname);

		// get system current date
		String startdate = jlib.getSystemDateYYYYDDMM();
		String enddate = jlib.getRequiredDateYYYDDMM(30);

		cip.getStartdate().clear();
		cip.getStartdate().sendKeys(startdate);
		cip.getEnddate().clear();
		cip.getEnddate().sendKeys(enddate);
		cip.getConsavebtn().click();

		String actstartdate = cip.getAstartdate().getText();
		if (actstartdate.trim().equals(startdate)) {
			System.out.println(startdate + " is correct");
		} else {
			System.out.println(startdate + " is not correct");
		}

		String actenddate = cip.getAenddate().getText();
		if (actenddate.trim().equals(enddate)) {
			System.out.println(enddate + " is correct");
		} else {
			System.out.println(enddate + " is not correct");
		}

	}

	@Test(groups="regressiontest")
	public void CreateContactWithOrgTest() throws EncryptedDocumentException, IOException {

		// testscript frome excel
		String lastName = elib.getFileFromExcel("sheet1", 1, 3) + jlib.getrandomNumber();
		String orgname = elib.getFileFromExcel("sheet1", 4, 2) + jlib.getrandomNumber();

		// navigate to Organizations module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// click create organization button
		OraganizationPage cnp = new OraganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// enter all details & create new organization
		CreatingNewOrganization cno = new CreatingNewOrganization(driver);
		cno.createOrg(orgname);

		// verify header expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actorgname = oip.getHeaderMsg().getText();
		if (actorgname.contains(orgname)) {
			System.out.println(orgname + "is created==pass");
		} else {
			System.out.println(orgname + "is not created==Fail");
		}

		// click on contacts module
		HomePage hp1 = new HomePage(driver);
		hp1.getContactlink().click();
		// click on + button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontact().click();

		// step 4: enter all the details and create new contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.getLastname().sendKeys(lastName);
		cip.getConsavebtn().click();

		// verify header Lastname info expected result
		String actLastName = cip.getLastnamefield().getText();
		if (actLastName.trim().equals(lastName)) {
			System.out.println(lastName + "is created==PASS");
		} else {
			System.out.println(lastName + "is created==FAIL");
		}

	}
}
