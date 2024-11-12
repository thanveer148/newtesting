package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganization {

    WebDriver driver;
    public CreatingNewOrganization(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);//this means current object reference
    }
    
  @FindBy(name="accountname")                        //org name text field
  private WebElement createNewOrg;
  
  @FindBy(xpath="//input[@accesskey=\"S\"]")
  private WebElement saveBtn;
  
  @FindBy(name="industry")                          // choose industry
  private WebElement industryDD;
  
  @FindBy(name="accounttype")                         //choose type
  private WebElement typeDD;
  
  @FindBy(name="phone")                              //choose phno field
  private WebElement phno;
  
   public WebElement getCreateNewOrg() {
	return createNewOrg;
}
    public WebElement getSaveBtn() {
	return saveBtn;
}
     public WebElement getIndustryDD() {
		return industryDD;
}
       public WebElement getTypeDD() {
		return typeDD;
}
       
	public WebElement getPhno() {
		return phno;
}
	
	//method overloading
	public void createOrg(String orgName) {                                 //only create organisation
    	createNewOrg.sendKeys(orgName);
    	saveBtn.click();
    }
	public void createOrg(String orgName,String industry) {                 // create organisation and select industry
		createNewOrg.sendKeys(orgName);
		Select select=new Select(industryDD);
		select.selectByVisibleText(industry);
		saveBtn.click();
	}
	public void createOrg(String orgName,String industry,String type) {   // create organisation and select industry and type
		createNewOrg.sendKeys(orgName);
		
		Select select=new Select(industryDD);
		select.selectByVisibleText(industry);
		
		Select select1=new Select(typeDD);
		select1.selectByVisibleText(type);                            
		saveBtn.click();
	}
	public void createOrg(String orgName,String industry,String type,String phonenumber) {   // create org,select industry,type,enter phno
		createNewOrg.sendKeys(orgName);
		
		Select select=new Select(industryDD);
		select.selectByVisibleText(industry);
		
		Select select1=new Select(typeDD);
		select1.selectByVisibleText(type);   
		
		phno.sendKeys(phonenumber);
		saveBtn.click();
	}
}
