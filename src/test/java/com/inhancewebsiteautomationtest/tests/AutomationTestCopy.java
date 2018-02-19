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

public class AutomationTestCopy{
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	WebDriverWait wait;		 
	
    Screen s = new Screen();        
    String firefoxIcon = "imgs/1518125167901.png";
    String firefoxAddressBar = "imgs/1518125179638.png";
    String homeAddress = "www.inhance.com\n";
    String hamburgerButton = "imgs/1518125213295.png";
    String workButton = "imgs/1518125240213.png";
    String workBackground = "imgs/1518131732322.png";
    String backButton = "imgs/1518137086693.png";
    String aboutButton = "imgs/1518136703950.png";
    String aboutBackground = "imgs/1518138066238.png";
    String newsButton = "imgs/1518138103438.png";
    String newsBackground ="imgs/1518138775741.png";
    String contactButton = "imgs/1518138127917.png";
    String contactBackground = "imgs/1518138158909.png";
    String logoButton = "imgs/1518141983517.png";
    String noVideoHomeBackground = "imgs/1518220451430.png";
    String xButton = "imgs/1518224134304.png";
    int waitInSecondsForBackground = 6;		

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
//		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.19.1-win64\\geckodriver.exe");
//	    driver = new FirefoxDriver();
//	    baseUrl = "http://www.inhance.com/";
//	    driver.get(baseUrl);
//	    driver.manage().window().maximize(); 
//	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	    
	}

//	  @Test
//	  public void smokeTest() {
//		wait = new WebDriverWait(driver, 20);		
//		
//		Given_PageIsHome_When_LogoIsPressed_Then_PageShouldBeHome();
//		Given_PageIsHome_When_PageIsLoaded_Then_BackgroundVideoSrcShouldBeAsGiven();
//		Given_PageIsHome_When_BackgroundIsVideo_Then_BackgroundVideoShouldPlay();
//		
//		//Hamburger Button
//	  }

//	@Test
//	public void given_PageIsHome_When_LogoIsPressed_Then_PageShouldBeHome() {		  
//		//Logo
//		WebElement element = driver.findElement(By.id("logo"));
//		element.click();
//		String actualUrl = driver.getCurrentUrl();
//		String expectedUrl = "http://www.inhance.com/";
//		Assert.assertEquals(actualUrl, expectedUrl);
//	}
//	@Test
//	public void given_PageIsHome_When_PageIsLoaded_Then_BackgroundVideoSrcShouldBeAsGiven() {		  
//		//Background
//		WebElement element = driver.findElement(By.id("background_video"));
//		String actualSrc = element.getAttribute("src");
//		String expectedSrc = "http://www.inhance.com/Inhance-library/mp4/cinematic_wallpaper_blue_v04-default.mp4";
//		Assert.assertEquals(actualSrc, expectedSrc);  
//	}
//	@Test
//	public void given_PageIsHome_When_BackgroundIsVideo_Then_BackgroundVideoShouldPlay() {		 
//		WebElement element = driver.findElement(By.id("background_video"));
//		float currentPlayTime = Float.parseFloat(element.getAttribute("currentTime"));
//		Assert.assertTrue(currentPlayTime>0);
//	}
	
//	public void given_PageIsHome_When_HamburgerButtonIsPressed_Then_WorkShouldBeDisplayed() {
//  	WebElement element = driver.findElement(By.xpath("//[@class="link"][@section="work"]"));
//	}

//	public boolean compare_Images(String imgOriginal, String imgToCopmareWithOriginal, String imgOutputDifferences) {	
//
//	}
	
//	public void when_WebsiteIsTypedIn_Then_HomePageAppears() {
//	openWebsiteWithSikuli();
//	//how to verify that this is the homepage?
//}
//
//
//public void given_UserIsInHomePage_When_HamburgerButtonIsPressed_Then_HamburgerMenuShouldBeDisplayed(Screen s) {
//	clickHamburgerButton();
//}
//
//public void given_UserIsInHomePage_When_HamburgerButtonIsPressed_AND_WorkButtonIsPressed_Then_WorkPageAppears() {
//	
//}	
//public void when_HamburgerButtonIsPressed_Then_WorkShouldBeDisplayed(Screen s) {
////Wait, Find, and Click Hamburger Button
//try {
//  s.wait(hamburgerButton,5);
//  s.click(hamburgerButton,0);
//}catch(FindFailed e) {
//	e.printStackTrace();
//}
//}
//
	
	@Test
	public void smokeTestWithSikuli() {		        
        openWebsiteWithSikuli();//can also use setUp() to have Selenium Webdriver open up the site
    	//Work Section
        clickHamburgerButton();
    	clickWorkButton();
    	checkWorkBackground();
    	clickBackButton();
        //About Section
    	clickHamburgerButton();
    	clickAboutButton();
    	checkAboutBackground();
    	clickBackButton();
        //News Section
    	clickHamburgerButton();
    	clickNewsButton();
    	checkNewsBackground();
    	clickBackButton();
        //Contact Section
    	clickHamburgerButton();
    	clickContactButton();
    	checkContactBackground();
//    	clickBackButton();
    	//Home Section
    	clickLogoButton();
    	checkHomeBackground();
    	clickXButton();//Currently has issues
	}
	
	//the below functions require dependencies on previous functions. The sequence is not top to bottom.
//	@Test 
//	public void initializeSmokeTest() {
//        openWebsiteWithSikuli();//can also use setUp() to have Selenium Webdriver open up the site
//	}
//	@Test
//	public void workSmokeTest() {
//        clickHamburgerButton();
//    	clickWorkButton();
//    	checkWorkBackground();
//    	clickBackButton();		
//	}
//	@Test
//	public void aboutSmokeTest() {
//    	clickHamburgerButton();
//    	clickAboutButton();
//    	checkAboutBackground();
//    	clickBackButton();
//	}
//	@Test
//	public void newsSmokeTest() {
//    	clickHamburgerButton();
//    	clickNewsButton();
//    	checkNewsBackground();
//    	clickBackButton();
//	}
//	@Test
//	public void contactSmokeTest() {
//    	clickHamburgerButton();
//    	clickContactButton();
//    	checkContactBackground();
//    	clickBackButton();
//	}

	public void openWebsiteWithSikuli() {
		try {
            s.click(firefoxIcon, 0);
            s.click(firefoxAddressBar, 0);
            s.type(null,homeAddress,0);
		}catch(FindFailed e) {
			e.printStackTrace();			
		}		
	}
	public void clickBackButton() {
		try {
            s.click(backButton,0);
		}catch(FindFailed e) {
			e.printStackTrace();
		}
	}
	public void clickLogoButton() {
		try {
			s.click(logoButton,0);
		}catch(FindFailed e) {
			e.printStackTrace();
		}
	}
	public void clickHamburgerButton() {
		try {
	        s.wait(hamburgerButton,5);
	        s.click(hamburgerButton,0);		
	    }catch(FindFailed e) {
	    	e.printStackTrace();
	    }	
	}
	public void clickWorkButton() {
		try {
            s.wait(workButton,5);
            s.click(workButton,0);
		}catch(FindFailed e) {
			e.printStackTrace();
		}
	}
	public void checkWorkBackground() {
		try {
            s.wait(workBackground,waitInSecondsForBackground);
            assert(s.exists(workBackground)!=null);
		}catch(FindFailed e) {
			e.printStackTrace();
		}
	}
	public void clickAboutButton() {
		try {
			s.wait(aboutButton,5);
            s.click(aboutButton,0);
		}catch(FindFailed e) {
			e.printStackTrace();
		}		
	}
	public void checkAboutBackground() {
		try {
            s.wait(aboutBackground,waitInSecondsForBackground);
            assert(s.exists(aboutBackground)!=null);
		}catch(FindFailed e) {
			e.printStackTrace();
		}	
	}
	public void clickNewsButton() {
		try {
			s.wait(newsButton,5);
			s.click(newsButton,0);
		}catch(FindFailed e) {
			e.printStackTrace();
		}		
	}
	public void checkNewsBackground() {
		try {
            s.wait(newsBackground,waitInSecondsForBackground);
            assert(s.exists(newsBackground)!=null);
		}catch(FindFailed e) {
			e.printStackTrace();
		}		
	}
	public void clickContactButton() {
		try {
            s.click(contactButton,0);
		}catch(FindFailed e){
            e.printStackTrace();
        }		
	}
	public void checkContactBackground() {
		try {
			s.wait(contactBackground,waitInSecondsForBackground);
			assert(s.exists(contactBackground)!=null);
		}catch(FindFailed e) {
			e.printStackTrace();			
		}	
	}

	public void checkHomeBackground() {
//		WebElement element = driver.findElement(By.id("background_video"));
//		float currentPlayTime = Float.parseFloat(element.getAttribute("currentTime"));
//		Assert.assertTrue(currentPlayTime>0);
		try {
			Assert.assertFalse(s.wait(noVideoHomeBackground, waitInSecondsForBackground)!=null);//this should fail since the background video should be playing
		}catch(FindFailed e) {
//			e.printStackTrace();
			System.out.println("Home background is not empty: Pass");
		}
	}
	
	public void clickXButton() {
		try {
			s.click(xButton);
		}catch(FindFailed e) {
			e.printStackTrace();		
		}	
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
//		driver.quit();
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
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

