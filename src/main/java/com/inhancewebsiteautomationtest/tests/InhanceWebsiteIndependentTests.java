package com.inhancewebsiteautomationtest.tests;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ntp.TimeStamp;

import junit.framework.Assert;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.lang.*;

import org.testng.ITestResult;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.basics.Debug;
import org.sikuli.script.*;
import org.frontendtest.*;
import java.sql.Timestamp;

public class InhanceWebsiteIndependentTests {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	WebDriverWait wait;	
	int waitInSecondsForBackground;
	int waitForDynamicElement;
	String fullScreenPageHeight;
	String homeBackground2;//there isn't homeBackground1, since there's a video instead, and these are for screenshots
	String homeBackground3;
	String homeBackground4;
	String workBackground;
	String aboutBackground;
	String newsBackground;
	String contactBackground;
	String careersBackground1a;//since the content in the careers page changes regularly, we can only check 
	String careersBackground1b;
	String logoButtonHomeHighlighted;
	String logoButtonWorkHighlighted;
	String logoButtonAboutHighlighted;
	String logoButtonNewsHighlighted;
	String logoButtonContactHighlighted;	
	String hamburgerButton;
	String hamburgerButtonHighlighted;
	String hamburgerMenu;
	String hamburgerMenuWorkHighlight;
	String hamburgerMenuAboutHighlight;
	String hamburgerMenuNewsHighlight;
	String hamburgerMenuContactHighlight;
	String xButton;
	String homeGalleryImage1;
	String homeGalleryImage2;
	String homeGalleryImage3;
	String homeViewAllButton;
	String homeLearnMoreButton;
	String homeMoreButton;
	String homePageAddress;
	String workPageAddress;
	String aboutPageAddress;
	String newsPageAddress;
	String contactPageAddress;
	String careersPageAddress;
	String caseStudyIntelWearablesAddress;
	String caseStudyAbMauriAddress;
	String caseStudyDellKeynote;
	String facebookAddress;
	String twitterAddress;
	String linkedInBaseAddress;
	String linkedInAddress;
	String linkedInAlternateAddress;
	String companyPhoneNumber;
	String companyEmail;
	Screen s;
	String intelWearablesBackground;
	String abMauriBackground;
	String dellKeynoteBackground;
	FluentWait<String> fluentWaitForBackground;

	InhanceWebsiteIndependentTests(){
		//TODO will have to make these global field values externally input-able
		homePageAddress = "http://www.inhance.com/";
		workPageAddress = "http://www.inhance.com/#work";
		aboutPageAddress = "http://www.inhance.com/#about";
		newsPageAddress = "http://www.inhance.com/#news";
		contactPageAddress = "http://www.inhance.com/#contact";	
		careersPageAddress = "http://www.inhance.com/#careers";
		facebookAddress = "https://www.facebook.com/InhanceDigital/";
		twitterAddress = "https://twitter.com/inhancedigital";
		linkedInBaseAddress = "https://www.linkedin.com";
		linkedInAddress = "https://www.linkedin.com/company/inhance-digital/";
		linkedInAlternateAddress = "https://www.linkedin.com/authwall";
		caseStudyIntelWearablesAddress = "http://www.inhance.com/#cs!Intel_Wearables_Data_Visualization_at_CES";
		caseStudyAbMauriAddress = "http://www.inhance.com/#cs!AB_Mauri_North_America_IBIE_Virtual_Reality";
		caseStudyDellKeynote = "http://www.inhance.com/#cs!Dell_EMC_Dell_EMC_World_Keynote_VR";
		waitInSecondsForBackground = 10;
		waitForDynamicElement = 6;
		fullScreenPageHeight = "1086";
		workBackground = "1518131732322.png";
		aboutBackground = "1518138066238.png";
		newsBackground = "1518138775741.png";
		contactBackground = "1518138158909.png";
		careersBackground1a = "1518637431569.png";
		careersBackground1b = "1518637406464.png";
		logoButtonHomeHighlighted = "1518567362868.png";
		logoButtonWorkHighlighted = "1518567523359.png";
		logoButtonAboutHighlighted = "1518567538418.png";
		logoButtonNewsHighlighted = "1518567554753.png";
		logoButtonContactHighlighted = "1518567568493.png";
		hamburgerButton = "1518561439335.png";
		hamburgerButtonHighlighted = "1518561729060.png";
		hamburgerMenu = "1518562267173.png";
		hamburgerMenuWorkHighlight = "1518562816908.png";
		hamburgerMenuAboutHighlight = "1518562807915.png";
		hamburgerMenuNewsHighlight = "1518562824643.png";
		hamburgerMenuContactHighlight = "1518562833140.png";
		xButton = "1518570167059.png";
		homeBackground2 = "1518574353752.png";
		homeBackground3 = "1518575379493.png";
		homeBackground4 = "1518575638657.png";
		homeGalleryImage1 = "1518576341805.png";
		homeGalleryImage2 = "1518576367501.png";
		homeGalleryImage3 = "1518576547769.png";
		homeViewAllButton = "1518576655263.png";
		homeLearnMoreButton = "1518634258112.png";
		homeMoreButton = "1518639790234.png";
		companyPhoneNumber = "(323) 297-7700";
		companyEmail = "info@inhance.com";
		intelWearablesBackground = "1518719988858.png";
		abMauriBackground = "1518720650236.png";
		dellKeynoteBackground = "1518720853732.png";
		s  = new Screen();
		ImagePath.add(MainOne.class.getCanonicalName()+"/images");
		
		
//		fluentWaitForBackground = new FluentWait<String>(homeBackground2);
//		fluentWaitForBackground.withTimeout(5000, TimeUnit.MILLISECONDS);
//		fluentWaitForBackground.pollingEvery(250, TimeUnit.MILLISECONDS);
//		fluentWaitForBackground.ignoring(NoSuchElementException.class);
//		Function<String, Boolean> waitThenCheckBackground = new Function<String,Boolean>(){
//			public Boolean apply(String img) {
//				if(s.compare(img) != null) {//then img is found
//					return true;
//				}
//				return false;
//			}
//		};
//		fluentWaitForBackground.until(waitThenCheckBackground);
	}
	
//	public FluentWait<String> generateFluentWaitForBackground(String background) {
//		FluentWait<String> fluentWaitForBackground = new FluentWait(background);
//		fluentWaitForBackground.withTimeout(5000, TimeUnit.MILLISECONDS);
//		fluentWaitForBackground.pollingEvery(250, TimeUnit.MILLISECONDS);
//		fluentWaitForBackground.ignoring(NoSuchElementException.class);
////		fluentWaitForBackground.ignoring(FindFailed.class);
//		Function<String, Boolean> waitThenCheckBackground = new Function<String,Boolean>(){
//			public Boolean apply(String img) {
//				if(s.compare(img) != null) {//then img is found
//					return true;
//				}
//				return false;
//			}
//		};
//		return fluentWaitForBackground;
//	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {		
		ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("geckodriver.exe");
        File f = new File("Driver");
        if (!f.exists()) {
            f.mkdirs();
        }
        File geckodriver = new File("Driver" + "\\geckodriver.exe");
        if (!geckodriver.exists()) {
        	geckodriver.createNewFile();
            FileUtils.copyURLToFile(resource, geckodriver);
        }
        String geckodriverLocation = geckodriver.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", geckodriverLocation);
        
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.inhance.com/";
	    driver.get(baseUrl);
	    driver.manage().window().maximize(); 
//	    driver.manage().window().setSize(new Dimension(1024, 768))
	    wait = new WebDriverWait(driver, 20);
	}
	
	//the below functions are independent of each other
	//this would solve TestNG's seemingly random execution order of tests, as well as ease of reportability and reproducibility
	//the format would be given_Location_when_Action_then_Result
	//TODO
//		@Test
//		protected void given_PageIsHome_when_() {
//	
//		}
	@Test
	protected void given_PageIsHome_when_PageIsLoaded_Then_BackgroundVideoIsPlayed() {
		WebElement element = driver.findElement(By.id("background_video"));
		float currentPlayTime = Float.parseFloat(element.getAttribute("currentTime"));
		if (!(currentPlayTime>0)){
			takeScreenshot();
			Assert.fail();
		}
	}
	@Test
	protected void given_PageIsHome_when_LogoIsHovered_then_LogoIsHighlighted() {
		WebElement element = driver.findElement(By.id("logo"));
		//clashes with Pattern from java.util.regex
		org.sikuli.script.Pattern pattern = new org.sikuli.script.Pattern(logoButtonHomeHighlighted).similar(0.7f);
		//Check default display of logo
		element.isDisplayed();
		
		//Hover and check highlight display
		Actions builder = new Actions(driver);		
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();
			builder.moveToElement(element).perform();
            s.wait(pattern,waitForDynamicElement);           
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}	
	}
	@Test
	protected void given_PageIsNotTopOfHome_when_LogoIsPressed_then_PageIsScrolledToTop() {
		long scrollValue = getPageYOffset();
		WebElement element = driver.findElement(By.id("logo"));

		scrollDownXFullScreenPageHeight(2);
        element.click();
        waitForScrollToFinish();

		scrollValue = getPageYOffset();
		Assert.assertEquals(0, scrollValue);
	}
	@Test
	protected void given_PageIsHome_when_HamburgerIsHovered_then_HamburgerIsHighlighted() {
//		WebElement element = driver.findElement(By.id("hamburger"));//hamburger is not clickable, but cross is
		WebElement element = driver.findElement(By.xpath("//div[@class='cross']"));
		element.isDisplayed();
		waitForHamburgerButtonAnimation();
		
		//Hover and check highlight
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		try {
            s.wait(hamburgerButtonHighlighted,waitForDynamicElement);
            assert(s.exists(hamburgerButtonHighlighted)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		element = driver.findElement(By.id("menu_cont"));//reset the highlighted Hamburger Button by moving to the top menu bar
		builder.moveToElement(element).perform();
	}
	@Test
	protected void given_PageIsHome_when_HamburgerIsPressed_then_HamburgerMenuIsOpened() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test
	protected void given_PageIsHomeAndHamburgerMenuIsOpen_when_XButtonIsPressed_then_HamburgerMenuIsClosed() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkXButton();
		clickXButton();
	}
	@Test
	protected void given_PageIsHomeAndHamburgerMenuIsOpened_when_WorkIsHovered_then_WorkIsHighlighted() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerMenuHighlightsWork();
	}
	@Test
	protected void given_PageIsHomeAndHamburgerMenuIsOpened_when_AboutIsHovered_then_AboutIsHighlighted() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerMenuHighlightsAbout();
	}
	@Test
	protected void given_PageIsHomeAndHamburgerMenuIsOpened_when_NewsIsHovered_then_NewsIsHighlighted() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerMenuHighlightsNews();
	}
	@Test
	protected void given_PageIsHomeAndHamburgerMenuIsOpened_when_ContactIsHovered_then_ContactIsHighlighted() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerMenuHighlightsContact();
	}
	@Test
	protected void given_PageIsHomeAndHamburgerMenuIsOpened_when_WorkIsClicked_then_PageIsNavigatedToWork() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerNavigationToWork();
	}
	@Test
	protected void given_PageIsHomeAndHamburgerMenuIsOpened_when_AboutIsClicked_then_PageIsNavigatedToAbout() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerNavigationToAbout();
	}
	@Test
	protected void given_PageIsHomeAndHamburgerMenuIsOpened_when_NewsIsClicked_then_PageIsNavigatedToNews() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerNavigationToNews();
	}
	@Test
	protected void given_PageIsHomeAndHamburgerMenuIsOpened_when_ContactIsClicked_then_PageIsNavigatedToContact() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerNavigationToContact();
	}
	@Test
	protected void given_PageIsHome_when_DownArrowIsClicked_then_PageIsScrolledToSecondPartOfHome() {
		checkDownArrow();
		clickDownArrow();
		//Check background
		try {
            s.wait(homeBackground2,waitInSecondsForBackground);
            assert(s.exists(homeBackground2)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test
	protected void given_PageIsSecondPartOfHome_when_FirstImageOfGalleryIsHovered_then_FirstImageOfGalleryIsExpanded() {
		checkDownArrow();
		clickDownArrow();
		checkHomeGalleryImage1Hover();
	}
	@Test
	protected void given_PageIsSecondPartOfHome_when_SecondImageOfGalleryIsHovered_then_SecondImageOfGalleryIsExpanded() {
		checkDownArrow();
		clickDownArrow();
		checkHomeGalleryImage2Hover();
	}
	@Test
	protected void given_PageIsSecondPartOfHome_when_ThirdImageOfGalleryIsHovered_then_ThirdImageOfGalleryIsExpanded() {
		checkDownArrow();
		clickDownArrow();
		checkHomeGalleryImage3Hover();
	}
	@Test
	protected void given_PageIsSecondPartOfHome_when_FirstImageOfGalleryIsClicked_then_PageIsNavigatedToIntelWearables() {
		checkDownArrow();
		clickDownArrow();
		checkHomeGalleryImage1NavigateToCaseStudy();
	}
	@Test
	protected void given_PageIsSecondPartOfHome_when_SecondImageOfGalleryIsClicked_then_PageIsNavigatedToAbMauri() {
		checkDownArrow();
		clickDownArrow();
		checkHomeGalleryImage2NavigateToCaseStudy();
	}
	@Test
	protected void given_PageIsSecondPartOfHome_when_ThirdImageOfGalleryIsClicked_then_PageIsNavigatedToDellKeynote() {
		checkDownArrow();
		clickDownArrow();
		checkHomeGalleryImage3NavigateToCaseStudy();
	}
	@Test
	protected void given_PageIsSecondPartOfHome_when_ViewAllButtonIsHovered_then_ViewAllButtonIsHighlighted() {
		checkDownArrow();
		clickDownArrow();
		checkHomeViewAllButton();
	}
	@Test
	protected void given_PageIsSecondPartOfHome_when_ViewAllButtonIsClicked_then_PageIsNavigatedToWork() {
		checkDownArrow();
		clickDownArrow();
		checkHomeViewAllButtonNavigateToWork();
	}
	@Test
	protected void given_PageIsThirdPartOfHome_when_LearnMoreButtonIsHovered_then_LearnMoreButtonIsHighlighted() {
		scrollDownXFullScreenPageHeight(2);
		checkHomeLearnMoreButtonHover();
	}
	@Test
	protected void given_PageIsThirdPartOfHome_when_LearnMoreButtonIsClicked_then_PageIsNavigatedToAbout() {
		scrollDownXFullScreenPageHeight(2);
		checkHomeLearnMoreButtonNavigateToAbout();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_MoreButtonIsHovered_then_MoreButtonIsHighlighted() {
		scrollDownXFullScreenPageHeight(3);
		checkHomeMoreButtonHover();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_MoreButtonIsClicked_then_PageIsNavigatedToContact() {
		scrollDownXFullScreenPageHeight(3);
		checkHomeMoreButtonNavigateToContact();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_RequestInfoIsClicked_then_PageIsNavigatedToContact() {
		scrollDownXFullScreenPageHeight(3);
		checkHomeRequestInfoLink();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_CareersIsClicked_then_PageIsNavigatedToCareers() {
		scrollDownXFullScreenPageHeight(3);
		checkHomeCareersLink();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_FacebookIsClicked_then_PageIsNavigatedToFacebook() {
		scrollDownXFullScreenPageHeight(3);
		checkHomeFacebookButton();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_TwitterIsClicked_then_PageIsNavigatedToTwitter() {
		scrollDownXFullScreenPageHeight(3);
		checkHomeTwitterButton();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_LinkedInIsClicked_then_PageIsNavigatedToLinkedIn() {
		scrollDownXFullScreenPageHeight(3);
		checkHomeLinkedInButton();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_PhoneNumberIsShown_then_PhoneNumberIsAccurate() {
		scrollDownXFullScreenPageHeight(3);
		checkHomePhoneNumberLinkAccuracy();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_PhoneNumberIsShown_then_PhoneNumberIsClickable() {
		scrollDownXFullScreenPageHeight(3);
		checkHomePhoneNumberLinkClickable();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_EmailIsShown_then_EmailIsAccurate() {
		scrollDownXFullScreenPageHeight(3);
		checkHomeEmailLinkAccuracy();
	}
	@Test
	protected void given_PageIsFourthPartOfHome_when_EmailIsShown_then_EmailIsClickable() {
		scrollDownXFullScreenPageHeight(3);
		checkHomeEmailLinkClickable();
	}
	protected void waitForScrollToFinish() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Wait<JavascriptExecutor> wait = new FluentWait<JavascriptExecutor>(executor)
			    .withTimeout(6, TimeUnit.SECONDS)
			    .pollingEvery(1, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);

		Boolean foo = wait.until(new Function<JavascriptExecutor, Boolean>() 
		{
			public Boolean apply(JavascriptExecutor executor) {
				if(getPageYOffset()==0) {
					System.out.println("Finally: " + getPageYOffset());
					return true;
				}else {
					System.out.println("Not Zero: " + getPageYOffset());
					return false;
				}
			}
		});		
	}
	
	protected void scrollDownXFullScreenPageHeight(int x) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String scrollheight = (Integer.parseInt(fullScreenPageHeight)*x)+"";
		jse.executeScript("window.scrollBy(0,"+scrollheight+")", "");
		System.out.println("Scrolling");
	}
	
	protected long getPageYOffset() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long value = (Long) executor.executeScript("return window.pageYOffset;");
		return value;
	}

	protected void checkHomeBackground(){
		WebElement element = driver.findElement(By.id("background_video"));
		float currentPlayTime = Float.parseFloat(element.getAttribute("currentTime"));
		if (!(currentPlayTime>0)){
			takeScreenshot();
			Assert.fail();
		}
	}
	protected void checkHomeBackground2() {
		//Check background
		try {
            s.wait(homeBackground2,waitInSecondsForBackground);
            assert(s.exists(homeBackground2)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	protected void checkHomeGalleryImage1() {
		//Hover and check gallery image 1 display
		checkHomeGalleryImage1Hover();
		checkHomeGalleryImage1NavigateToCaseStudy();
	}
	protected void checkHomeGalleryImage1Hover() {
		String xpathExpression = "//div[@id=\"home\"]/div[@class=\"page\"][2]/div[@class=\"case_study_list\"]/div[@cs=\"Intel Wearables Data Visualization at CES\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		try {
			s.wait(homeBackground2, waitInSecondsForBackground);
			System.out.println("Finished waiting for background with Sikuli");
			builder.moveToElement(element).perform();
            s.wait(homeGalleryImage1,waitForDynamicElement);
//            assert(s.exists(homeGalleryImage1)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}		
	}
	protected void checkHomeGalleryImage1NavigateToCaseStudy() {
		String xpathExpression = "//div[@id=\"home\"]/div[@class=\"page\"][2]/div[@class=\"case_study_list\"]/div[@cs=\"Intel Wearables Data Visualization at CES\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		try {
			s.wait(homeBackground2, waitInSecondsForBackground);
			System.out.println("Finished waiting for background with Sikuli");
			builder.moveToElement(element).perform();
			element.click();
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		wait.until(ExpectedConditions.urlContains(caseStudyIntelWearablesAddress));
		Assert.assertEquals(caseStudyIntelWearablesAddress, driver.getCurrentUrl());
		checkIntelWearablesBackground();
	}
	protected void checkIntelWearablesBackground() {
		try {
            s.wait(intelWearablesBackground,waitInSecondsForBackground);
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();	
			Assert.fail();
		}	
	}

	protected boolean checkIfOnTopOfPage() {
		boolean onTop = false;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long value = (Long) executor.executeScript("return window.pageYOffset;");
		if(value==0) {
			onTop = true;
		}
		return onTop;
	}
	protected void checkHomeGalleryImage2() {
		checkHomeGalleryImage2Hover();
		checkHomeGalleryImage2NavigateToCaseStudy();
	}
	protected void checkHomeGalleryImage2Hover() {
		//Hover and check gallery image 2 display
		String xpathExpression = "//div[@id=\"home\"]/div[@class=\"page\"][2]/div[@class=\"case_study_list\"]/div[@cs=\"AB Mauri North America IBIE Virtual Reality\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		try {
			s.wait(homeBackground2, waitInSecondsForBackground);
			System.out.println("Finished waiting for background with Sikuli");
			builder.moveToElement(element).perform();
            s.wait(homeGalleryImage2,waitInSecondsForBackground);
            System.out.println("Finished waiting for image with Sikuli");
//            assert(s.exists(homeGalleryImage2)!=null);          
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	protected void checkHomeGalleryImage2NavigateToCaseStudy() {
		String xpathExpression = "//div[@id='home']//div[@class='page']//div[@class='case_study_list']//div[@cs='AB Mauri North America IBIE Virtual Reality']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		try {
			s.wait(homeBackground2, waitInSecondsForBackground);
			System.out.println("Finished waiting for background with Sikuli");
			builder.moveToElement(element).perform();
			element.click();
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		wait.until(ExpectedConditions.urlContains(caseStudyAbMauriAddress));
		Assert.assertEquals(caseStudyAbMauriAddress, driver.getCurrentUrl());
		checkAbMauriBackground();
	}
	protected void checkAbMauriBackground() {
		try {
            s.wait(abMauriBackground,waitInSecondsForBackground);
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();	
			Assert.fail();
		}	
	}

	protected void checkHomeGalleryImage3() {
		checkHomeGalleryImage3Hover();
		checkHomeGalleryImage3NavigateToCaseStudy();
	}
	protected void checkHomeGalleryImage3Hover() {
		//Hover and check gallery image 3 display
		String xpathExpression = "//div[@id=\"home\"]/div[@class=\"page\"][2]/div[@class=\"case_study_list\"]/div[@cs=\"Dell EMC Dell EMC World Keynote VR\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		try {
			s.wait(homeBackground2, waitInSecondsForBackground);
			System.out.println("Finished waiting for background with Sikuli");
			builder.moveToElement(element).perform();
            s.wait(homeGalleryImage3,waitForDynamicElement);
//            assert(s.exists(homeGalleryImage3)!=null);          
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	protected void checkHomeGalleryImage3NavigateToCaseStudy() {
		String xpathExpression = "//div[@id='home']//div[@class='page']//div[@class='case_study_list']//div[@cs='Dell EMC Dell EMC World Keynote VR']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		try {
			s.wait(homeBackground2, waitInSecondsForBackground);
			System.out.println("Finished waiting for background with Sikuli");
			builder.moveToElement(element).perform();
			element.click();
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		wait.until(ExpectedConditions.urlContains(caseStudyDellKeynote));
		Assert.assertEquals(caseStudyDellKeynote, driver.getCurrentUrl());
		checkDellKeynoteBackground();
	}
	protected void checkDellKeynoteBackground() {
		try {
            s.wait(dellKeynoteBackground,waitInSecondsForBackground);
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();	
			Assert.fail();
		}	
	}
	protected void checkHomeViewAllButton() {
		checkHomeViewAllButtonHover();
		checkHomeViewAllButtonNavigateToWork();
	}
	protected void checkHomeViewAllButtonHover() {
		//hover and check
		String xpathExpression = "//div[@id=\"home\"]/div[@class=\"page\"][2]/button[@section=\"work\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		try {
			s.wait(homeBackground2,waitInSecondsForBackground);
			builder.moveToElement(element).perform();
            s.wait(homeViewAllButton,waitInSecondsForBackground);
            assert(s.exists(homeViewAllButton)!=null);          
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	protected void checkHomeViewAllButtonNavigateToWork() {
		String xpathExpression = "//div[@id=\"home\"]/div[@class=\"page\"][2]/button[@section=\"work\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);	
		try {
			s.wait(homeBackground2,waitInSecondsForBackground);
			builder.moveToElement(element).perform();
            s.wait(homeViewAllButton,waitInSecondsForBackground);
            element.click();  
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		wait.until(ExpectedConditions.urlContains(workPageAddress));
		Assert.assertEquals(workPageAddress, driver.getCurrentUrl());
		checkWorkBackground();
	}
	
	protected void checkHomeBackground3() {//these next ones should be navigated to by scroll with pixels
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+fullScreenPageHeight+")", "");
		try {
            s.wait(homeBackground3,waitInSecondsForBackground);
            assert(s.exists(homeBackground3)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}		
		checkHomeLearnMoreButton();
	}
	
	protected void checkHomeLearnMoreButton() {
		checkHomeLearnMoreButtonHover();
		checkHomeLearnMoreButtonNavigateToAbout();
	}
	protected void checkHomeLearnMoreButtonHover() {
		//hover and check
		String xpathExpression = "//div[@id=\"home\"]/div[@class=\"page about_page\"]/button[@class=\"more_button\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		try {
			s.wait(homeBackground3,waitInSecondsForBackground);
			builder.moveToElement(element).perform();
            s.wait(homeLearnMoreButton,waitForDynamicElement);    
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	protected void checkHomeLearnMoreButtonNavigateToAbout() {
		String xpathExpression = "//div[@id=\"home\"]/div[@class=\"page about_page\"]/button[@class=\"more_button\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		try {
            s.wait(homeBackground3,waitInSecondsForBackground);
    		builder.moveToElement(element).perform();
    		element.click();   
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}		
		wait.until(ExpectedConditions.urlContains(aboutPageAddress));
		Assert.assertEquals(aboutPageAddress, driver.getCurrentUrl());
		checkAboutBackground();
	}

	protected void checkHomeBackground4() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+fullScreenPageHeight+")", "");
		try {
            s.wait(homeBackground4,waitInSecondsForBackground);
            assert(s.exists(homeBackground4)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHomeMoreButton();
		checkHomeRequestInfoLink();
		checkHomeCareersLink();
		checkHomeFacebookButton();
		checkHomeTwitterButton();
		checkHomeLinkedInButton();
		checkHomePhoneNumberLink();
		checkHomeEmailLink();
	}
	protected void checkHomeMoreButton() {
		checkHomeMoreButtonHover();
		checkHomeMoreButtonNavigateToContact();
	}
	protected void checkHomeMoreButtonHover() {
		String xpathExpression = "//div[@id=\"home\"]/div[@id=\"mobile_footer\"]/button[@section=\"contact\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		try {
			s.wait(homeBackground4,waitInSecondsForBackground);
			builder.moveToElement(element).perform();
            s.wait(homeMoreButton,waitForDynamicElement);                
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}		
	}

	protected void checkHomeMoreButtonNavigateToContact() {
		String xpathExpression = "//div[@id='home']//div[@id='mobile_footer']//button[@section='contact']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
		
		try {
			s.wait(homeBackground4,waitInSecondsForBackground);
			builder.moveToElement(element).perform();
			element.click();             
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}		
		wait.until(ExpectedConditions.urlContains(contactPageAddress));
		Assert.assertEquals(contactPageAddress, driver.getCurrentUrl());
		checkContactBackground();
	}

	protected void checkHomeRequestInfoLink() {
		String xpathExpression = "//div[@id=\"home\"]/div[@id=\"footer\"]/div[@class=\"popup_footer\"]/div[@id=\"landscape\"]/div[@class=\"top_a\"]/div[@class=\"footer_right\"]/div[@section=\"contact\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		try {
			s.wait(homeBackground4,waitInSecondsForBackground);
			element.click();             
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}		
		Assert.assertEquals(driver.getCurrentUrl(), contactPageAddress);
		checkContactBackground();
	}
	protected void checkHomeCareersLink() {
		String xpathExpression = "//div[@id=\"home\"]/div[@id=\"footer\"]/div[@class=\"popup_footer\"]/div[@id=\"landscape\"]/div[@class=\"top_a\"]/div[@class=\"footer_right\"]/div[@section=\"careers\"]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		try {
			s.wait(homeBackground4,waitInSecondsForBackground);
			element.click();             
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}		
		Assert.assertEquals(driver.getCurrentUrl(), careersPageAddress);
		checkCareersBackground();
	}
	protected void checkHomeFacebookButton() {
		String xpathExpression = "//div[@id='home']//div[@id='footer']//div[@class='popup_footer']//div[@id='landscape']//div[@class='top_b']//div[@class='footer_left']//div[@class='social_media']//div[@class='fb']//a[@href='https://www.facebook.com/InhanceDigital/']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));		
		//use to get back
		String winHandleBefore = driver.getWindowHandle();
		//open new tab
		try {
			s.wait(homeBackground4,waitInSecondsForBackground);
			element.click();             
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}	
		//have to wait in order for window handles to properly store the newly opened tab
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//the while loop is there to wait for the window handle to store the new tab
		while(driver.getWindowHandles().size()<2);
		Set<String> windowHandles = driver.getWindowHandles();
		//gets the last opened window
		for(String winHandle : windowHandles){
			//focuses the driver onto the last opened tab
			//the if here is there to deal with times when the driver's tab focus isn't consistent 
			if(!(winHandle.equals(winHandleBefore))) {
				driver.switchTo().window(winHandle);
			}	
		}		
		//have to wait even more to make sure the address is there
		wait.until(ExpectedConditions.urlContains(facebookAddress));
		//since facebook is an external site, then just verifying navigation is fine
		Assert.assertEquals(driver.getCurrentUrl(), facebookAddress);
		//Close Facebook Page
		driver.close();
		//Go back to the previous page		
		driver.switchTo().window(winHandleBefore);
		System.out.println("checkHomeFacebookButton() ending");
	}
	protected void checkHomeTwitterButton() {
		String xpathExpression = "//div[@id='home']//div[@id='footer']//div[@class='popup_footer']//div[@id='landscape']//div[@class='top_b']//div[@class='footer_left']//div[@class='social_media']//div[@class='tw']//a[@href='https://twitter.com/inhancedigital']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));		
		//use to get back
		String winHandleBefore = driver.getWindowHandle();
		//open new tab
		try {
			s.wait(homeBackground4,waitInSecondsForBackground);
			element.click();             
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}	
		//have to wait in order for window handles to properly store the newly opened tab
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		while(driver.getWindowHandles().size()<2);
		Set<String> windowHandles = driver.getWindowHandles();
		//gets the last opened window
		for(String winHandle : windowHandles){
			//focuses the driver onto the last opened tab
			//the if here is there to deal with times when the driver's tab focus isn't consistent 
			if(!(winHandle.equals(winHandleBefore))) {
				driver.switchTo().window(winHandle);
			}	
		}		
		//have to wait even more to make sure the address is there
		wait.until(ExpectedConditions.urlContains(twitterAddress));
		//since twitter is an external site, then just verifying navigation is fine
		Assert.assertEquals(driver.getCurrentUrl(), twitterAddress);
		//Close Twitter Page
		driver.close();
		//Go back to the previous page
		driver.switchTo().window(winHandleBefore);
		System.out.println("checkHomeTwitterButton() ending");
	}
	protected void checkHomeLinkedInButton() {
		String xpathExpression = "//div[@id='home']//div[@id='footer']//div[@class='popup_footer']//div[@id='landscape']//div[@class='top_b']//div[@class='footer_left']//div[@class='social_media']//div[@class='ln']//a[@href='https://www.linkedin.com/company/inhance-digital/']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));		
		//use to get back
		String winHandleBefore = driver.getWindowHandle();
		//open new tab
		try {
			s.wait(homeBackground4,waitInSecondsForBackground);
			element.click();             
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}	
		//have to wait in order for window handles to properly store the newly opened tab
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		while(driver.getWindowHandles().size()<2);
		Set<String> windowHandles = driver.getWindowHandles();
		//gets the last opened window
		for(String winHandle : windowHandles){
			//focuses the driver onto the last opened tab
			//the if here is there to deal with times when the driver's tab focus isn't consistent 
			if(!(winHandle.equals(winHandleBefore))) {
				driver.switchTo().window(winHandle);
			}	
		}		
		//have to wait even more to make sure the address is there
		wait.until(ExpectedConditions.urlContains(linkedInBaseAddress));
		
		//the bottom if else should also catch the authwall
		//since twitter is an external site, then just verifying proper navigation is fine
		if(driver.getCurrentUrl().equals(linkedInAddress)){
			Assert.assertEquals(driver.getCurrentUrl(), linkedInAddress);
		}else if(driver.getCurrentUrl().equals(linkedInAlternateAddress)) {
			Assert.assertEquals(driver.getCurrentUrl(), linkedInAlternateAddress);
		}
		
		//Close LinkedIn Page
		driver.close();
		//Go back to the previous page
		driver.switchTo().window(winHandleBefore);
		System.out.println("checkHomeLinkedInButton() ending");		
	}
	protected void checkHomePhoneNumberLink() {
		String xpathExpression = "//div[@id='home']//div[@id='footer']//div[@class='popup_footer']//div[@id='landscape']//div[@class='top_b']//div[@class='footer_right']//div[@class='company_contact divide phone']//a[@href='tel:3232977700']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		String innerHtml = element.getAttribute("innerHTML");
		Assert.assertEquals(companyPhoneNumber, innerHtml);
		try {
			s.wait(homeBackground4,waitInSecondsForBackground);
			element.isDisplayed();           
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}	
		System.out.println("checkHomePhoneNumberLink() end"); 
	}
	protected void checkHomePhoneNumberLinkAccuracy() {
		String xpathExpression = "//div[@id='home']//div[@id='footer']//div[@class='popup_footer']//div[@id='landscape']//div[@class='top_b']//div[@class='footer_right']//div[@class='company_contact divide phone']//a[@href='tel:3232977700']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		String innerHtml = element.getAttribute("innerHTML");
		Assert.assertEquals(companyPhoneNumber, innerHtml);
		System.out.println("checkHomePhoneNumberLinkAccuracy() end"); 
	}
	protected void checkHomePhoneNumberLinkClickable() {
		String xpathExpression = "//div[@id='home']//div[@id='footer']//div[@class='popup_footer']//div[@id='landscape']//div[@class='top_b']//div[@class='footer_right']//div[@class='company_contact divide phone']//a[@href='tel:3232977700']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		try {
			s.wait(homeBackground4,waitInSecondsForBackground);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}	
		System.out.println("checkHomePhoneNumberLinkClickable() end"); 
	}
	protected void checkHomeEmailLink() {
		String xpathExpression = "//div[@id='home']//div[@id='footer']//div[@class='popup_footer']//div[@id='landscape']//div[@class='top_b']//div[@class='footer_right']//div[@class='company_contact email']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		String innerHtml = element.getAttribute("innerHTML");
		Assert.assertEquals(companyEmail, innerHtml);
		element.isDisplayed();	
		System.out.println("checkHomeEmailLink() end"); 
	}
	protected void checkHomeEmailLinkAccuracy() {
		String xpathExpression = "//div[@id='home']//div[@id='footer']//div[@class='popup_footer']//div[@id='landscape']//div[@class='top_b']//div[@class='footer_right']//div[@class='company_contact email']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		String innerHtml = element.getAttribute("innerHTML");
		Assert.assertEquals(companyEmail, innerHtml);
		System.out.println("checkHomePhoneNumberLinkAccuracy() end"); 
	}
	protected void checkHomeEmailLinkClickable() {
		String xpathExpression = "//div[@id='home']//div[@id='footer']//div[@class='popup_footer']//div[@id='landscape']//div[@class='top_b']//div[@class='footer_right']//div[@class='company_contact email']";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		String innerHtml = element.getAttribute("innerHTML");
		Assert.assertEquals(companyEmail, innerHtml);
		try {
			s.wait(homeBackground4,waitInSecondsForBackground);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}	
		System.out.println("checkHomeEmailLinkClickable() end"); 
	}

	protected void checkInhanceLogoHome() {
		WebElement element = driver.findElement(By.id("logo"));
		//clashes with Pattern from java.util.regex
		org.sikuli.script.Pattern pattern = new org.sikuli.script.Pattern(logoButtonHomeHighlighted).similar(0.7f);
		//Check default display
		element.isDisplayed();
		
		//Hover and check highlight display
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		try {
            s.wait(pattern,waitForDynamicElement);
            assert(s.exists(pattern)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}		
	}
	
	protected void checkHamburgerMenu() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkXButton();
		clickXButton();
	}
	protected void checkHamburgerMenuWork() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerMenuHighlightsWork();
		checkHamburgerNavigationToWork();
	}
	protected void checkHamburgerMenuHighlightsWork() {
		WebElement element;
		Actions builder;
		
		//check that Work highlights
		element = driver.findElement(By.xpath("//div[@section='work']"));
		builder = new Actions(driver);
		builder.moveToElement(element).perform();
		try {
            s.wait(hamburgerMenuWorkHighlight,waitForDynamicElement);
            assert(s.exists(hamburgerMenuWorkHighlight)!=null);         
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	protected void checkHamburgerNavigationToWork() {
		clickWorkButton();
		checkWorkBackground();
//		driver.navigate().back();
	}
	protected void clickWorkButton() {
		WebElement element = driver.findElement(By.xpath("//div[@section='work']"));
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@section='work']")));
		element.click();
	}
	protected void checkWorkBackground() {//use sikulix here, since the background-img loading is handled by css and there may be some difficulty using image verification with Selenium
		try {
            s.wait(workBackground,waitInSecondsForBackground);
            assert(s.exists(workBackground)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	protected void checkHamburgerMenuAbout() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerMenuHighlightsAbout();
		checkHamburgerNavigationToAbout();
	}
	protected void checkHamburgerNavigationToAbout() {
		clickAboutButton();
		checkAboutBackground();
//		driver.navigate().back();
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
			takeScreenshot();
			e.printStackTrace();	
			Assert.fail();
		}
	}
	protected void checkHamburgerMenuNews() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerMenuHighlightsNews();
		checkHamburgerNavigationToNews();
	}
	protected void checkHamburgerNavigationToNews() {
		clickNewsButton();
		checkNewsBackground();
//		driver.navigate().back();
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
			takeScreenshot();
			e.printStackTrace();	
			Assert.fail();
		}		
	}
	protected void checkHamburgerMenuContact() {
		checkHamburgerButton();
		clickHamburgerButton();
		//Check menu
		try {
            s.wait(hamburgerMenu,waitForDynamicElement);
            assert(s.exists(hamburgerMenu)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		checkHamburgerMenuHighlightsContact();
		checkHamburgerNavigationToContact();
	}
	protected void checkHamburgerNavigationToContact() {
		clickContactButton();
		checkContactBackground();
//		driver.navigate().back();
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
			takeScreenshot();
			e.printStackTrace();	
			Assert.fail();
		}
	}
	protected void checkDownArrow() {
		WebElement element = driver.findElement(By.xpath("//img[@class='arrow']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.isDisplayed();
	}
	
	protected void clickDownArrow() {
		WebElement element = driver.findElement(By.xpath("//img[@class='arrow']"));
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//		element.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	protected void checkHamburgerButton() {
//		WebElement element = driver.findElement(By.id("hamburger"));//hamburger is not clickable, but cross is
		WebElement element = driver.findElement(By.xpath("//div[@class='cross']"));
		element.isDisplayed();
		waitForHamburgerButtonAnimation();
		
		//Hover and check highlight
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		try {
            s.wait(hamburgerButtonHighlighted,waitForDynamicElement);
            assert(s.exists(hamburgerButtonHighlighted)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
		element = driver.findElement(By.id("menu_cont"));//reset the highlighted Hamburger Button by moving to the top menu bar
		builder.moveToElement(element).perform();
	}
	
	protected void waitForHamburgerButtonAnimation() {
		WebElement element = driver.findElement(By.xpath("//div[@class='cross']"));
		element.isDisplayed();
		
		try {
            s.wait(hamburgerButton,waitForDynamicElement);
            assert(s.exists(hamburgerButton)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}		
	}	
	
	protected void clickHamburgerButton() {//this shouldn't be just for work
		WebElement element = driver.findElement(By.id("menu_toggle"));
		element.click();		
		String xPathexpression = "//div[@section='work']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathexpression)));
	}
		
	protected void checkXButton() {
		WebElement element = driver.findElement(By.xpath("//div[@class='cross']"));
		element.isDisplayed();		
		//Check button and then close
		try {
            s.wait(xButton,waitForDynamicElement);
            assert(s.exists(xButton)!=null);            
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	protected void clickXButton() {
		WebElement element = driver.findElement(By.xpath("//div[@class='cross']"));
		element.isDisplayed();	
		element.click();		
		s.waitVanish(hamburgerMenu,waitForDynamicElement);
	}
	

	protected void checkHamburgerMenuHighlightsAbout() {
		WebElement element;
		Actions builder = new Actions(driver);
				
		//check that About highlights
		element = driver.findElement(By.xpath("//div[@section='about']"));
		builder = new Actions(driver);
		builder.moveToElement(element).perform();
		try {
            s.wait(hamburgerMenuAboutHighlight,waitForDynamicElement);
            assert(s.exists(hamburgerMenuAboutHighlight)!=null);         
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	protected void checkHamburgerMenuHighlightsNews() {
		WebElement element;
		Actions builder = new Actions(driver);
		
		//check that News highlights
		element = driver.findElement(By.xpath("//div[@section='news']"));
		builder = new Actions(driver);
		builder.moveToElement(element).perform();
		try {
            s.wait(hamburgerMenuNewsHighlight,waitForDynamicElement);
            assert(s.exists(hamburgerMenuNewsHighlight)!=null);         
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	protected void checkHamburgerMenuHighlightsContact() {
		WebElement element;
		Actions builder = new Actions(driver);
		
		//check that Contact highlights
		element = driver.findElement(By.xpath("//div[@section='contact']"));
		builder = new Actions(driver);
		builder.moveToElement(element).perform();
		try {
            s.wait(hamburgerMenuContactHighlight,waitForDynamicElement);
            assert(s.exists(hamburgerMenuContactHighlight)!=null);         
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();
			Assert.fail();
		}
	}	
	protected void clickBackButton() {
		driver.navigate().back();	
	}

	
	


	
	protected void checkCareersBackground() {
		try {
            s.wait(careersBackground1a,waitInSecondsForBackground);
            assert(s.exists(careersBackground1a)!=null);
            s.wait(careersBackground1b,waitInSecondsForBackground);
            assert(s.exists(careersBackground1b)!=null);
		}catch(FindFailed e) {
			takeScreenshot();
			e.printStackTrace();	
			Assert.fail();
		}
	}
	
	protected void takeScreenshot() {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Long timestamp = (new Timestamp(System.currentTimeMillis())).getTime();
		System.out.println("Taking screenshot at: "+timestamp);
		try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot"+ timestamp +".png"));
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}		
	}
	@AfterMethod
	public void afterMethod() {
		driver.get(baseUrl);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.navigate().to("about:config");
		driver.navigate().to("about:blank");
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

