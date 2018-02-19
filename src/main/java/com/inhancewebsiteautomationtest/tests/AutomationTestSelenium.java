package com.inhancewebsiteautomationtest.tests;

import org.testng.annotations.Test;
import junit.framework.Assert;
import java.util.regex.Pattern;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.basics.Debug;
import org.sikuli.script.*;
//import org.frontendtest.*;

public class AutomationTestSelenium {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	WebDriverWait wait;	
	int waitInSecondsForBackground;
	String workBackground;
	String aboutBackground;
	String newsBackground;
	String contactBackground;
	Screen s = new Screen();
	
//	AutomationTestSelenium(){
//		waitInSecondsForBackground = 6;
//		workBackground = "imgs/1518131732322.png";
//		aboutBackground = "imgs/1518138066238.png";
//		newsBackground ="imgs/1518138775741.png";
//		contactBackground = "imgs/1518138158909.png";
//	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.inhance.com/";
	    driver.get(baseUrl);
	    driver.manage().window().maximize(); 
	    wait = new WebDriverWait(driver, 20);	
		waitInSecondsForBackground = 6;
		workBackground = "imgs/1518131732322.png";
		aboutBackground = "imgs/1518138066238.png";
		newsBackground ="imgs/1518138775741.png";
		contactBackground = "imgs/1518138158909.png";	    
	}

	//the below functions require dependencies on previous functions but the TestNG execution sequence is not top to bottom. 
	//Unless we include priorities and dependencies. (Would allow us to view TestNG results)
	@Test
	protected void homeSmokeTest() {
		checkHomeBackground();
	}
	@Test
	public void workSmokeTest() {
		clickHamburgerButton();
    	clickWorkButton();
    	checkWorkBackground();
    	clickBackButton();		
	}
	@Test
	public void aboutSmokeTest() {
    	clickHamburgerButton();
    	clickAboutButton();
    	checkAboutBackground();
    	clickBackButton();
	}
	@Test
	public void newsSmokeTest() {
    	clickHamburgerButton();
    	clickNewsButton();
    	checkNewsBackground();
    	clickBackButton();
	}
	@Test
	public void contactSmokeTest() {
    	clickHamburgerButton();
    	clickContactButton();
    	checkContactBackground();
    	clickBackButton();
	}

	protected void checkHomeBackground() {
		WebElement element = driver.findElement(By.id("background_video"));
		float currentPlayTime = Float.parseFloat(element.getAttribute("currentTime"));
		Assert.assertTrue(currentPlayTime>0);
	}

	protected void clickHamburgerButton() {
		WebElement element = driver.findElement(By.id("menu_toggle"));
		element.click();		
		String expression = "//div[@section='work']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expression)));
	}
	
	protected void clickWorkButton() {
		WebElement element = driver.findElement(By.xpath("//div[@section='work']"));
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@section='work']")));
		element.click();
	}
	
	protected void checkWorkBackground() {//use sikulix here, since the background-img loading is handled by css
		try {
            s.wait(workBackground,waitInSecondsForBackground);
            assert(s.exists(workBackground)!=null);
		}catch(FindFailed e) {
			e.printStackTrace();
		}
	}
	
	protected void clickBackButton() {
		driver.navigate().back();	
	}
	
	protected void clickAboutButton() {
		WebElement element = driver.findElement(By.xpath("//div[@section='about']"));
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@section='about']")));
		element.click();
	}
	
	protected void checkAboutBackground() {
		try {
            s.wait(aboutBackground,waitInSecondsForBackground);
            assert(s.exists(aboutBackground)!=null);
		}catch(FindFailed e) {
			e.printStackTrace();
		}
	}
	
	protected void clickNewsButton() {
		WebElement element = driver.findElement(By.xpath("//div[@section='news']"));
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@section='news']")));
		element.click();
	}
	
	protected void checkNewsBackground() {
		try {
            s.wait(newsBackground,waitInSecondsForBackground);
            assert(s.exists(newsBackground)!=null);
		}catch(FindFailed e) {
			e.printStackTrace();
		}		
	}

	protected void clickContactButton() {
		WebElement element = driver.findElement(By.xpath("//div[@section='contact']"));
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@section='contact']")));
		element.click();
	}
	
	protected void checkContactBackground() {
		try {
            s.wait(contactBackground,waitInSecondsForBackground);
            assert(s.exists(contactBackground)!=null);
		}catch(FindFailed e) {
			e.printStackTrace();
		}
	}

	
	
	
	
//	public void given_PageIsHome_When_LogoIsPressed_Then_PageShouldBeHome() {		  
//		//Logo
//		WebElement element = driver.findElement(By.id("logo"));
//		element.click();
//		String actualUrl = driver.getCurrentUrl();
//		String expectedUrl = "http://www.inhance.com/";
//		Assert.assertEquals(actualUrl, expectedUrl);
//	}
//	
//	public void given_PageIsHome_When_PageIsLoaded_Then_BackgroundVideoSrcShouldBeAsGiven() {		  
//		//Background
//		WebElement element = driver.findElement(By.id("background_video"));
//		String actualSrc = element.getAttribute("src");
//		String expectedSrc = "http://www.inhance.com/Inhance-library/mp4/cinematic_wallpaper_blue_v04-default.mp4";
//		Assert.assertEquals(actualSrc, expectedSrc);  
//	}
//
//	public void given_PageIsHome_When_BackgroundIsVideo_Then_BackgroundVideoShouldPlay() {		 
//		WebElement element = driver.findElement(By.id("background_video"));
//		float currentPlayTime = Float.parseFloat(element.getAttribute("currentTime"));
//		Assert.assertTrue(currentPlayTime>0);
//	}


	

	

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}

