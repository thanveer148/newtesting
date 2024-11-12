package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.Java_Utility;

public class ContactInfoPage {
	 WebDriver driver;
	    public ContactInfoPage(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);//this means current object reference(HomePage)
	    }
	    
	    @FindBy(name="lastname")                              //latname field contact page
	    private WebElement lastname;
	    
		public WebElement getLastname() {
			return lastname;
		}
	    
		@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")          //save button in contact field
	    private WebElement consavebtn;
		
		public WebElement getConsavebtn() {
			return consavebtn;
		}  
		
		@FindBy(id="mouseArea_Last Name")                              //latname field after save contact info page
	    private WebElement lastnamefield;
		
		public WebElement getLastnamefield() {
			return lastnamefield;
		}
		
     @FindBy(name="support_start_date")                               //support start date contact info page
     private WebElement startdate;
     @FindBy(name="support_end_date")                                 //support end date contact info page
     private WebElement enddate;
     
	public WebElement getStartdate() {
		return startdate;
	}
	public WebElement getEnddate() {
		return enddate;
	}
	
	 @FindBy(id="mouseArea_Support Start Date")                      //support start date after enter contact info page
     private WebElement astartdate;
     @FindBy(id="mouseArea_Support End Date")                        //support end date after enter contact info page
     private WebElement aenddate;
	public WebElement getAstartdate() {
		return astartdate;
	}
	public WebElement getAenddate() {
		return aenddate;
	}
                                                                     //oragination name + button
	@FindBy(xpath="(//img[@title=\"Select\"])[1]")
	private WebElement addOrgBtn;
	
	public WebElement getAddOrgBtn() {
		return addOrgBtn;
	}
	
	@FindBy(id="search_txt")                         //child window search field
	private WebElement orgChildWindowSearchField;
	
	public WebElement getOrgChildWindowSearchField() {
		return orgChildWindowSearchField;
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")      //save button in child window
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void selectOrginChildWin(String orgname)     //org name enter and sumbit button in child window
	{
		orgChildWindowSearchField.sendKeys(orgname);
		orgChildWindowSearchField.submit();
		
	}
}
