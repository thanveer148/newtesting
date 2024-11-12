package com.crm.generic.baseUtility;

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

import com.comcast.crm.generic.fileutility.Excel_utility;
import com.comcast.crm.generic.fileutility.File_Utility;
import com.comcast.crm.generic.webdriverutility.Java_Utility;
import com.comcast.crm.generic.webdriverutility.WebDriver_Utility;
import com.comcast.crm.genericdatabaseutility.Database_Utility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	//create object
	 public  Database_Utility dlib=new Database_Utility();//we want use other package we put public
	 public File_Utility flib=new File_Utility();
	 public  Excel_utility elib=new Excel_utility();
	 public  WebDriver_Utility wlib=new  WebDriver_Utility();
	 public  Java_Utility jlib=new Java_Utility();
	 public WebDriver driver;
	 public static  WebDriver Sdriver=null;
	
	@BeforeSuite(groups={"smoketest","regressiontest"})
	public void configBS() {
		System.out.println("connect DB-Report Config");
		dlib.getconnection();
		
		 
	}
	
	//@Parameters("Browser")
	@BeforeClass(groups={"smoketest","regressiontest"})
	public void configBC(/*String browser*/) throws Throwable {
		System.out.println("Launch the Browser");
		//String Browser=browser;                                       //this is take value from xml  file
		String Browser=flib.getDataFromPropertiesFile("browser");       //this is take value from property file
		//String Browser=System.getProperty("Browser");
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		Sdriver=driver;
		}
	
	@BeforeMethod(groups={"smoketest","regressiontest"})
	public void configBM() throws Throwable {
		System.out.println("Log In");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.logintoapp(URL, USERNAME, PASSWORD);
	}
	@AfterMethod(groups={"smoketest","regressiontest"})
	public void configAM() {
		System.out.println("Log out");
	HomePage hp= new HomePage(driver);
		hp.logout();
	}
	@AfterClass(groups={"smoketest","regressiontest"})
	public void configAC() {
		System.out.println("Close the Browser");
		driver.quit();
	}
	@AfterSuite(groups={"smoketest","regressiontest"})
	public void configAS() {
		System.out.println("Close DB-Report Backup");
		dlib.closeDbconnection();
		
		 	}
}
