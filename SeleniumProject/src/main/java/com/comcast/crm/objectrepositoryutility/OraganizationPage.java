package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OraganizationPage {
	
	 WebDriver driver;
	    public OraganizationPage(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);//this means current object reference(HomePage)
	    }
	   @FindBy(name="search_text")
	   private WebElement searchEdt;
	   
	   @FindBy(name="search_field")
	   private WebElement searchDD;
	   
       @FindBy(xpath="//img[@alt=\"Create Organization...\"]")    //click + button
        private  WebElement createNewOrgBtn;
       
       @FindBy(xpath="//input[@name=\"submit\"]")
       private WebElement searchBtn;
  
     public WebElement getCreateNewOrgBtn() {
	return createNewOrgBtn;
   }

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
   
}
