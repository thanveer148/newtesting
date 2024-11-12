package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
    public OrganizationInfoPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);//this means current object reference(LoginPage)
    }
	
          @FindBy(className="dvHeaderText")                    //org name in top left side
          private WebElement headerMsg;
          @FindBy(id="mouseArea_Organization Name")            //org name text field
          private WebElement orgnamefield;
          @FindBy(id="mouseArea_Industry")                     //industry text field
          private WebElement indfield;
          @FindBy(id="mouseArea_Type")                          //type text field
          private WebElement typefield;
          @FindBy(id="mouseArea_Phone")                          //type text field
          private WebElement phnofield;

          
		public WebElement getHeaderMsg() {
			return headerMsg;
		}


		public WebElement getOrgnamefield() {
			return orgnamefield;
		}


		public WebElement getIndfield() {
			return indfield;
		}


		public WebElement getTypefield() {
			return typefield;
		}


		public WebElement getPhnofield() {
			return phnofield;
		}
          
}
