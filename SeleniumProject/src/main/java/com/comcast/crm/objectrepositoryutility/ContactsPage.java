package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	 WebDriver driver;
	    public ContactsPage(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);//this means current object reference(HomePage)
	    }
	    
	    @FindBy(xpath="//img[@title=\"Create Contact...\"]")                    //click + button
	    private WebElement createcontact;
	    
		public WebElement getCreatecontact() {
			return createcontact;
		}
	    
	    @FindBy(className ="dvHeaderText")
	    private WebElement headerinfo;
		public WebElement getHeaderinfo() {
			return headerinfo;
		}
	    
}
