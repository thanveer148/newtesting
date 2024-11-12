package com.comcast.crm.objectrepositoryutility;
/**
 *@author thanveer
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriver_Utility;

public class LoginPage extends WebDriver_Utility{        //rule 1 create a separte java class
	                            //rule 2 object creation
	WebDriver driver;
    public LoginPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);//this means current object reference(LoginPage)
    }
	@FindBy(name="user_name")
	public WebElement usernameEdt;
	
	@FindBy(name="user_password")
	public WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	public WebElement loginBtn;
	                           //rule 3 object initialization
		                       //rule 4 object encapsulation
	public WebElement getusernameEdt() {
		return usernameEdt;
	}

	public WebElement getpasswordEdt() {
		return passwordEdt;
	}

	public WebElement getloginBtn() {
		return loginBtn;
	}
	/**
	 * login to application based on username and password
	 * @param url
	 * @param username
	 * @param password
	 */
	 //rule 5 provide action --------------------------------This is used for specifi application
	public void logintoapp(String url,String username,String password) {
		waitForPageLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginBtn.click();
	}
	
}
