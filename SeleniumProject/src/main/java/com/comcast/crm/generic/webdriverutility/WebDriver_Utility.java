package com.comcast.crm.generic.webdriverutility;


import java.io.File;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	public void waitForPageLoad(WebDriver driver) {                             //implicit
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void waitForElementPresent(WebDriver driver,WebElement element) {     //explicit
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void switchToTabonURL(WebDriver driver,String partailURL) {             //child window
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it= set.iterator();
		while (it.hasNext()) {
			String windowID =  it.next();
			driver.switchTo().window(windowID);
			
			String acturl=driver.getCurrentUrl();
			if(acturl.contains(partailURL)) {
				break;
			}
			
		}
	}
	public void switchToTabonTitle(WebDriver driver,String partailTitle) {             //parent window
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it= set.iterator();
		while (it.hasNext()) {
			String windowID =  it.next();
			driver.switchTo().window(windowID);
			
			String acturl=driver.getTitle();
			if(acturl.contains(partailTitle)) {
				break;
			}
			
		}
	}
	
	
	public void switchToFrame(WebDriver driver,int index) {         //this overloaded method for frames
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	                                                                //Alert popup
	
	public void switchtoAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
    public void switchtoAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
                                                                   //select class for dropdown
	                                           
	public void selectByText(WebElement element,String text) {
		Select select =new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement element,int index) {
		Select select =new Select(element);
		select.selectByIndex(index);
	}
	public void selectByValue(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);
	}
	                                                               //Action class for mouse movement
	public void mousemoveonElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		}
	public void  doubleclick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
		}
	
	public void takeScreenShot(WebDriver driver,String path) throws Throwable          //TakeScreenShot
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File scrfile=ts.getScreenshotAs(OutputType.FILE);
		File distfile=new File(path);
		FileHandler.copy(scrfile, distfile);
	}
	 
}
