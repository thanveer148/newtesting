package com.comcast.crm.orgtestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OraganizationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.crm.generic.baseUtility.BaseClass;

import junit.framework.Assert;
@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateOrgTest extends BaseClass {

	@Test(groups="regressiontest")
	public void CreateOrg_With_OrgTest() throws EncryptedDocumentException, IOException {
		ListImpClass.test.log(Status.INFO,"read data from excel");
		// read testscript file in EXCEL
		String orgname = elib.getFileFromExcel("sheet1", 10, 2) + jlib.getrandomNumber();
		String contactlastname = elib.getFileFromExcel("sheet1", 10, 3) + jlib.getrandomNumber();
		// navigate to Organizations module
		ListImpClass.test.log(Status.INFO,"navigate to org page");

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// click create organization button
		ListImpClass.test.log(Status.INFO,"navigate to create org page");

		OraganizationPage cnp = new OraganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// enter all details & create new organization
		ListImpClass.test.log(Status.INFO,"create new org");
		CreatingNewOrganization cno = new CreatingNewOrganization(driver);
		
		cno.createOrg(orgname);
		ListImpClass.test.log(Status.INFO,orgname+"===create a new org===");

		// Take from create org with phno
		// verify header expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actname = oip.getHeaderMsg().getText();
		if (actname.contains(orgname)) {
			System.out.println(orgname + " is created==pass");
		} else {
			System.out.println(orgname + " is not created==Fail");
		}

		// take from create contactwith lastname
		// click on contacts module
		HomePage hp1 = new HomePage(driver);
		hp1.getContactlink().click();

		// click on + button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontact().click();

		// step 4: enter all the details and create new organisation
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.getLastname().sendKeys(contactlastname);
		// cip.getConsavebtn().click();

		// Organization //window popups
		cip.getAddOrgBtn().click();

		// switch to child window
		wlib.switchToTabonURL(driver, "module=Accounts");

		cip.selectOrginChildWin(orgname);

		driver.findElement(By.xpath("//a[.='" + orgname + "']")).click();

		// switch to parent window
		wlib.switchToTabonURL(driver, "Contacts&action");

		// save button
		cip.getSaveBtn().click();
		
        //verfy in header
		String actheaderinfo =  cp.getHeaderinfo()	.getText();	
		boolean status=actheaderinfo.contains(contactlastname);            
		Assert.assertEquals(status, true);
//		if (headerinfo.contains(contactlastname)) {
//			System.out.println(contactlastname + "is created==pass");
//		} else {
//			System.out.println(contactlastname + "is not created==Fail");
//		}

		// verify header orgname info expected result
		String actorgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actorgname, orgname);
//		if (actorgname.contains(orgname)) {
//			System.out.println(actorgname + " is created");
//		} else {
//			System.out.println(actorgname + " is not created");
//		}
	}

	@Test(groups="regressiontest")
	public void CreateOrgAndDelete() throws EncryptedDocumentException, IOException {
		// read testscript file in EXCEL
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

		// go back to organizations page
		hp.getOrglink().click();
		// search for organization
		cnp.getSearchEdt().sendKeys(orgname);
		wlib.selectByText(cnp.getSearchDD(), "Organization Name");
		cnp.getSearchBtn().click();

		driver.findElement(By.xpath("//a[.=\"" + orgname + "\"]/../../td[8]/a[text()='del']")).click();
		// in dynamic webtable select & delete org
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}

	@Test(groups="smoketest")
	public void createOrganization() throws EncryptedDocumentException, IOException {
		// read testscript file in EXCEL
		String orgname = elib.getFileFromExcel("sheet1", 1, 2) + jlib.getrandomNumber();

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

		// verify textfield
		String textfield = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (textfield.contains(orgname)) {
			System.out.println(textfield + "is created");
		} else {
			System.out.println(textfield + "is not created");
		}

	}
}
