package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 @FindBy(linkText = "Organizations")                              //  navigate to organisation page
     private WebElement orglink;
	 
	 @FindBy(linkText = "Contacts")                                   //navigate to contacts page
     private WebElement contactlink;
	 
	 @FindBy(linkText ="Campaigns")
	 private WebElement campaignlink;
	 
	 @FindBy(linkText ="More")
	 private WebElement morelink;
	 
	 @FindBy(linkText ="Sign Out")
	 private WebElement signOutLink;
	 
	 @FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	 private WebElement adminImg;
	 
	 WebDriver driver;
	    public HomePage(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);//this means current object reference(HomePage)
	    }
	    
	    
		public WebElement getOrglink() {
			return orglink;
		}
		public WebElement getContactlink() {
			return contactlink;
		}
		public WebElement getCampaignlink() {
			return campaignlink;
		}
        public WebElement getMorelink() {
			return morelink;
		}
        public WebElement getAdminImg() {
			return adminImg;
		}


		public void navigateToCampaginPage() {
			Actions action=new Actions(driver);
			action.moveToElement(campaignlink).perform();
		    campaignlink.click();
		}
		
		public void logout()     {                                         //bussiness method for logout
		Actions action=new Actions(driver);
		action.moveToElement(adminImg).perform();
		signOutLink.click();
}
}