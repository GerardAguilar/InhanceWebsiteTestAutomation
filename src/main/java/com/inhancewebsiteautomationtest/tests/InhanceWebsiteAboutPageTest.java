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
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.basics.Debug;
import org.sikuli.script.*;
import org.frontendtest.*;
import java.sql.Timestamp;

public class InhanceWebsiteAboutPageTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	protected WebDriverWait wait;	
	protected int waitInSecondsForBackground;
	protected int waitForDynamicElement;
	protected String fullScreenPageHeight;	
	protected String workBackground;
	protected String aboutBackground;
	protected String newsBackground;
	protected String contactBackground;
	protected String careersBackground1a;//since the content in the careers page changes regularly, we can only check 
	protected String careersBackground1b;
	protected String logoButtonHomeHighlighted;
	protected String logoButtonWorkHighlighted;
	protected String logoButtonAboutHighlighted;
	protected String logoButtonAboutDehighlighted;
	protected String logoButtonNewsHighlighted;
	protected String logoButtonContactHighlighted;	
	protected String hamburgerButton;
	protected String hamburgerButtonHighlighted;
	protected String hamburgerButtonDehighlighted;
	protected String aboutHamburgerButtonHighlighted;
	protected String aboutHamburgerButtonDehighlighted;
	protected String aboutHamburgerButtonDehighlightedWhenInAbout;
	protected String workHamburgerButtonHighlighted;
	protected String workHamburgerButtonDehighlighted;
	protected String newsHamburgerButtonHighlighted;
	protected String newsHamburgerButtonDehighlighted;
	protected String hamburgerMenu;
	protected String hamburgerMenuWorkHighlight;
	protected String hamburgerMenuAboutHighlight;
	protected String hamburgerMenuNewsHighlight;
	protected String hamburgerMenuContactHighlight;
	protected String xButton;
	protected String homePageAddress;
	protected String workPageAddress;
	protected String aboutPageAddress;
	protected String newsPageAddress;
	protected String contactPageAddress;
	protected String careersPageAddress;
	protected String facebookAddress;
	protected String twitterAddress;
	protected String iTTPageAddress;
	protected String linkedInBaseAddress;
	protected String linkedInAddress;
	protected String linkedInAlternateAddress;
	protected String companyPhoneNumber;
	protected String companyEmail;
	protected Screen s;
	protected FluentWait<String> fluentWaitForBackground;
	
	protected String hamburgerXPath;
	protected String aboutXPath;
	protected String workXPath;
	protected String logoXPath;
	protected String xButtonXPath;
	protected String newsXPath;
	protected String contactXPath;
	protected String contactHamburgerButtonHighlighted;
	protected String contactHamburgerButtonDehighlighted;
	protected String downArrowXPath;
	protected String aboutBackground2;
	protected String aerospaceLinkXPath;
	protected String aerospaceLinkHovered;
	protected String aerospaceLinkUnhovered;
	protected String aerospaceBackground;
	protected String aerospacePageAddress;
	protected String iTTelecomLinkXPath;
	protected String iTTelecomLinkHovered;
	protected String iTTelecomLinkUnhovered;
	protected String iTTBackground;
	
	protected Region upperHalf;
	protected Region lowerHalf;
	protected Region leftHalf;
	protected Region rightHalf;
	protected Region fullScreen;
	protected int width;
	protected int height;
	protected String healthcareLinkXPath;
	protected String healthcareLinkHovered;
	protected String healthcareLinkUnhovered;
	protected String healthcarePageAddress;
	protected String healthcareBackground;
	private String energyLinkHovered;
	private String energyLinkXPath;
	private String energyLinkUnhovered;
	private String energyPageAddress;
	private String energyBackground;
	private String automotiveLinkHovered;
	private String automotiveLinkXPath;
	private String automotiveLinkUnhovered;
	private String automotivePageAddress;
	private String automotiveBackground;
	private String moreButtonXPath;
	private String moreButtonHovered;
	private String moreButtonUnhovered;

	InhanceWebsiteAboutPageTest(){
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
		aerospacePageAddress = "http://www.inhance.com/#industries!Aerospace";
		iTTPageAddress = "http://www.inhance.com/#industries!IT/Telecom";
		healthcarePageAddress = "http://www.inhance.com/#industries!healthcare";
		energyPageAddress = "http://www.inhance.com/#industries!energy";
		automotivePageAddress = "http://www.inhance.com/#industries!Automotive";
		
		waitInSecondsForBackground = 10;
		waitForDynamicElement = 6;
		fullScreenPageHeight = "1086";
		workBackground = "1518131732322.png";
		aboutBackground = "1518138066238.png";
		aboutBackground2 = "1519158064609.png";
		newsBackground = "1518138775741.png";
		contactBackground = "1518138158909.png";
		careersBackground1a = "1518637431569.png";
		careersBackground1b = "1518637406464.png";
		aerospaceBackground = "1519164506915.png";
		iTTBackground = "1519170407860.png";
		healthcareBackground = "1519176242130.png";
		energyBackground = "1519177139633.png";
		automotiveBackground = "1519244588151.png";
		logoButtonHomeHighlighted = "1518567362868.png";
		logoButtonWorkHighlighted = "1518567523359.png";
		logoButtonAboutHighlighted = "1518567538418.png";
		logoButtonAboutDehighlighted = "1519087671910.png";
		logoButtonNewsHighlighted = "1518567554753.png";
		logoButtonContactHighlighted = "1518567568493.png";
		hamburgerButton = "1518561439335.png";
		hamburgerButtonHighlighted = "1518561729060.png";
		aboutHamburgerButtonHighlighted = "1519089955933.png";
		aboutHamburgerButtonDehighlighted = "1519089770236.png";
		aboutHamburgerButtonDehighlightedWhenInAbout = "1519155852029.png";
		workHamburgerButtonHighlighted = "1519152734952.png";
		workHamburgerButtonDehighlighted = "1519152743314.png";
		newsHamburgerButtonHighlighted = "1519156799710.png";
		newsHamburgerButtonDehighlighted = "1519156785391.png";
		contactHamburgerButtonHighlighted = "1519157577267.png";
		contactHamburgerButtonDehighlighted = "1519157498879.png";
		hamburgerMenu = "1518562267173.png";
		hamburgerMenuWorkHighlight = "1518562816908.png";
		hamburgerMenuAboutHighlight = "1518562807915.png";
		hamburgerMenuNewsHighlight = "1518562824643.png";
		hamburgerMenuContactHighlight = "1518562833140.png";
		xButton = "1518570167059.png";

		companyPhoneNumber = "(323) 297-7700";
		companyEmail = "info@inhance.com";

		s  = new Screen();		
		
		ImagePath.add(MainOne.class.getCanonicalName()+"/images");
		
		hamburgerXPath = "//div[@class='cross']";
		aboutXPath = "//div[@section='about']";
		workXPath = "//div[@section='work']";
		logoXPath = "//div[@id='logo']";
		xButtonXPath = "//div[@class='cross']";
		newsXPath = "//div[@section='news'][contains(text(),'news')]";
		contactXPath = "//div[@section='contact'][contains(text(),'contact')]";
		downArrowXPath = "//div[@id='about']//div[@class='page']//img[@src='/icons/arrow.svg']";
		aerospaceLinkXPath = "//div[@name='Aerospace']//div[@class='label']";
		iTTelecomLinkXPath = "//div[@name='IT/Telecom']//div[@class='label']";
		healthcareLinkXPath = "//div[@name='healthcare']//div[@class='label']";
		energyLinkXPath = "//div[@name='energy']//div[@class='label']";
		automotiveLinkXPath = "//div[@name='Automotive']//div[@class='label']";
		moreButtonXPath = "//div[@id='mobile_footer']//button[@section='contact']";
		aerospaceLinkHovered = "1519167128893.png";
		aerospaceLinkUnhovered = "1519166713599.png";
		iTTelecomLinkHovered = "1519169670608.png";
		iTTelecomLinkUnhovered = "1519174673187.png";//"1519172651791.png";
		healthcareLinkHovered = "1519176100188.png";
		healthcareLinkUnhovered = "1519176054901.png";
		energyLinkHovered = "1519177112834.png";
		energyLinkUnhovered = "1519177120956.png";
		automotiveLinkHovered = "1519244299388.png";
		automotiveLinkUnhovered = "1519244285498.png";
		moreButtonHovered = "1519245111062.png";
		moreButtonUnhovered = "1519245335653.png";
		
		width = 1920;
		height = 1200;
		
		upperHalf = new Region(0,0,width, height/2);
//		upperHalf.highlight();
		lowerHalf = new Region(0,height/2, width, height/2);
//		lowerHalf.highlight();
		leftHalf = new Region(0,0,width/2, height);
//		leftHalf.highlight();
		rightHalf = new Region(width/2,0,width/2, height);
//		rightHalf.highlight();
		fullScreen = new Region(0,0, width, height);
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {	
		ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("geckodriver.exe");
        String os = System.getProperty("os.name").toLowerCase();
        File f = new File("Driver");
        if (!f.exists()) {
            f.mkdirs();
        }
        File geckodriver;

        //In the case of a MAC, we may need to copy the tar.gz file and then reference the resulting geckodriver application
        if(os.contains("mac")) {
            geckodriver = new File(System.getProperty("user.dir") + "/geckodriver");  
        }else {
        	geckodriver = new File("Driver" + "\\geckodriver.exe"); 
            if (!geckodriver.exists()) {
            	geckodriver.createNewFile();
                FileUtils.copyURLToFile(resource, geckodriver);
            }
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
//		protected void given_PageIsAbout_when_() {
//	
//		}
	
//	@Test 
//	protected void given_AboutPage_when_Loaded_then_AboutPageIsLoaded() {
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkAddressOfPage(aboutPageAddress);
//	}	
//	@Test 
//	protected void given_AboutPage_when_Loaded_then_PageBackgroundIsDisplayed(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkPageBackgroundIsDisplayed(aboutBackground);	
//	}
//	
//	@Test 
//	protected void given_AboutLogoButton_when_Hovered_then_Highlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkHighlightWhenHoveredOverOfElement(logoXPath, logoButtonAboutHighlighted);
//	}
//	@Test 
//	protected void given_AboutLogoButton_when_Unhovered_then_Dehighlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(logoXPath, logoButtonAboutHighlighted, logoButtonAboutDehighlighted, fullScreen);
//	}	
//	@Test 
//	protected void given_AboutHamburgerButton_when_Hovered_then_Highlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkHighlightWhenHoveredOverOfElement(hamburgerXPath, aboutHamburgerButtonHighlighted);
//	}
//	@Test 
//	protected void given_AboutHamburgerButton_when_Unhovered_then_Dehighlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(hamburgerXPath, aboutHamburgerButtonHighlighted,aboutHamburgerButtonDehighlighted, fullScreen);
//	}
//	@Test 
//	protected void given_AboutHamburgerButton_when_Pressed_then_MenuIsDisplayed(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		checkPageImageIsDisplayed(hamburgerMenu,1500,0,420,1200);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonXSelection_when_Pressed_then_MenuDisappears(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		clickButton(hamburgerXPath);
//		clickButton(xButtonXPath);
//		checkPageBackgroundIsNotVisible(aboutBackground, hamburgerMenu);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonWorkSelection_when_Hovered_then_Highlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		checkHighlightWhenHoveredOverOfElement(workXPath, workHamburgerButtonHighlighted);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonWorkSelection_when_Unhovered_then_Dehighlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(workXPath, workHamburgerButtonHighlighted, workHamburgerButtonDehighlighted, fullScreen);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonWorkSelection_when_Clicked_then_WorkPageIsLoaded(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		clickButton(workXPath);
//		checkAddressOfPage(workPageAddress);
//		checkPageBackgroundIsDisplayed(workBackground);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonAboutSelection_when_Hovered_then_Highlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		checkHighlightWhenHoveredOverOfElement(aboutXPath, aboutHamburgerButtonHighlighted);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonAboutSelection_when_Unhovered_then_Dehighlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(aboutXPath, aboutHamburgerButtonHighlighted, aboutHamburgerButtonDehighlightedWhenInAbout, fullScreen);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonAboutSelection_when_Clicked_then_MenuDisappears(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkPageBackgroundIsDisplayed(aboutBackground);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonNewsSelection_when_Hovered_then_Highlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		checkHighlightWhenHoveredOverOfElement(newsXPath, newsHamburgerButtonHighlighted);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonNewsSelection_when_Unhovered_then_Dehighlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(newsXPath, newsHamburgerButtonHighlighted, newsHamburgerButtonDehighlighted, fullScreen);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonNewsSelection_when_Clicked_then_NewsPageIsLoaded(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		clickButton(newsXPath);
//		checkAddressOfPage(newsPageAddress);
//		checkPageBackgroundIsDisplayed(newsBackground);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonContactSelection_when_Hovered_then_Highlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		checkHighlightWhenHoveredOverOfElement(contactXPath, contactHamburgerButtonHighlighted);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonContactSelection_when_Unhovered_then_Dehighlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(contactXPath, contactHamburgerButtonHighlighted, contactHamburgerButtonDehighlighted, fullScreen);
//	}
//	@Test 
//	protected void given_AboutHamburgerButtonContactSelection_when_Clicked_then_ContactPageIsLoaded(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(hamburgerXPath);
//		clickButton(contactXPath);
//		checkAddressOfPage(contactPageAddress);
//		checkPageBackgroundIsDisplayed(contactBackground);
//	}
//	@Test 
//	protected void given_AboutDownArrowButton_when_Clicked_then_ContactPageIsLoaded(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(downArrowXPath);
//		checkPageBackgroundIsDisplayed(aboutBackground2);
//	}
//	@Test 
//	protected void given_AboutAerospaceLink_when_Hovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkHighlightWhenHoveredOverOfElement(aerospaceLinkXPath, aerospaceLinkHovered);
//	}
//	@Test
//	protected void given_AboutAerospaceLink_when_Unhovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
////		checkDehighlightWhenNoLongerHoveredOverOfElement(aerospaceLinkXPath, aerospaceLinkHovered, aerospaceLinkUnhovered);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(aerospaceLinkXPath, aerospaceLinkHovered, aerospaceLinkUnhovered, lowerHalf);
//	}
//	@Test 
//	protected void given_AboutAerospaceLink_when_Clicked_then_AerospacePageIsLoaded(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(aerospaceLinkXPath);
//		checkAddressOfPage(aerospacePageAddress);
//		checkPageBackgroundIsDisplayed(aerospaceBackground);
//	}
//	@Test
//	protected void given_AboutITTelecomLink_when_Hovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkHighlightWhenHoveredOverOfElement(iTTelecomLinkXPath, iTTelecomLinkHovered);
//	}
//	@Test
//	protected void given_AboutITTelecomLink_when_Unhovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
////		checkDehighlightWhenNoLongerHoveredOverOfElement(iTTelecomLinkXPath, iTTelecomLinkHovered, iTTelecomLinkUnhovered);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(iTTelecomLinkXPath, iTTelecomLinkHovered, iTTelecomLinkUnhovered, lowerHalf);
//	}
//	@Test
//	protected void given_AboutITTelecomLink_when_Clicked_then_ITTPageIsLoaded(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(iTTelecomLinkXPath);
//		checkAddressOfPage(iTTPageAddress);
//		checkPageBackgroundIsDisplayed(iTTBackground);
//	}
//	@Test
//	protected void given_AboutHealthcareLink_when_Hovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkHighlightWhenHoveredOverOfElement(healthcareLinkXPath, healthcareLinkHovered);
//	}
//	@Test
//	protected void given_AboutHealthcareLink_when_Unhovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(healthcareLinkXPath, healthcareLinkHovered, healthcareLinkUnhovered, lowerHalf);
//	}
//	@Test
//	protected void given_AboutHealthcareLink_when_Clicked_then_ITTPageIsLoaded(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(healthcareLinkXPath);
//		checkAddressOfPage(healthcarePageAddress);
//		checkPageBackgroundIsDisplayed(healthcareBackground);
//	}
//	@Test
//	protected void given_AboutEnergyLink_when_Hovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkHighlightWhenHoveredOverOfElement(energyLinkXPath, energyLinkHovered);
//	}
//	@Test
//	protected void given_AboutEnergyLink_when_Unhovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(energyLinkXPath, energyLinkHovered, energyLinkUnhovered, lowerHalf);
//	}
//	@Test
//	protected void given_AboutEnergyLink_when_Clicked_then_EnergyPageIsLoaded(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(energyLinkXPath);
//		checkAddressOfPage(energyPageAddress);
//		checkPageBackgroundIsDisplayed(energyBackground);
//	}
//	@Test
//	protected void given_AboutAutomotiveLink_when_Hovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkHighlightWhenHoveredOverOfElement(automotiveLinkXPath, automotiveLinkHovered);
//	}
//	@Test
//	protected void given_AboutAutomotiveLink_when_Unhovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(automotiveLinkXPath, automotiveLinkHovered, automotiveLinkUnhovered, lowerHalf);
//	}
//	@Test
//	protected void given_AboutAutomotiveLink_when_Clicked_then_EnergyPageIsLoaded(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
//		clickButton(automotiveLinkXPath);
//		checkAddressOfPage(automotivePageAddress);
//		checkPageBackgroundIsDisplayed(automotiveBackground);
//	}
	//TODO
	@Test 
	protected void given_AboutMoreButton_when_Hovered_then_Animate(){
		clickButton(hamburgerXPath);
		clickButton(aboutXPath);
		checkAddressOfPage(aboutPageAddress);
//		scrollDownXFullScreenPageHeight(2);
		scrollDownXFullScreenPageHeightAndWait(2);
//		waitForScrollToFinish();
		checkHighlightWhenHoveredOverOfElement(moreButtonXPath, moreButtonHovered);
	}
//	@Test
//	protected void given_AboutMoreButton_when_Unhovered_then_Animate(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
////		scrollDownXFullScreenPageHeight(2);
//		scrollDownXFullScreenPageHeightAndWait(2);
////		waitForScrollToFinish();
//		checkDehighlightWhenNoLongerHoveredOverOfElement(moreButtonXPath, moreButtonHovered, moreButtonUnhovered, lowerHalf);
//	}
//	@Test
//	protected void given_AboutMoreButton_when_Clicked_then_ContactPageIsLoaded(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkAddressOfPage(aboutPageAddress);
////		scrollDownXFullScreenPageHeight(2);
//		scrollDownXFullScreenPageHeightAndWait(2);
////		waitForScrollToFinish();
//		clickButton(moreButtonXPath);
//		checkAddressOfPage(contactPageAddress);
//		checkPageBackgroundIsDisplayed(contactBackground);
//	}
//	@Test protected void given_AboutRequestInfoLink_when_Action_then_Result(){}
//	@Test protected void given_AboutCareersLink_when_Action_then_Result(){}
//	@Test protected void given_AboutFacebookButton_when_Action_then_Result(){}
//	@Test protected void given_AboutTwitterButton_when_Action_then_Result(){}
//	@Test protected void given_AboutLinkedInButton_when_Action_then_Result(){}
//	@Test protected void given_AboutPhoneNumberLink_when_Action_then_Result(){}
//	@Test protected void given_AboutEmailAddressLink_when_Action_then_Result(){}
//	
//	@Test
//	protected void given_PageIsNotTopOfAbout_when_LogoIsPressed_then_PageIsScrolledToTop() {
//		long scrollValue = getPageYOffset();
//		WebElement element = driver.findElement(By.id("logo"));
//
//		scrollDownXFullScreenPageHeight(2);
//        element.click();
//        waitForScrollToFinish();
//
//		scrollValue = getPageYOffset();
//		Assert.assertEquals(0, scrollValue);
//	}
	
	protected void waitForScrollToFinish() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Wait<JavascriptExecutor> wait = new FluentWait<JavascriptExecutor>(executor)
			    .withTimeout(6, TimeUnit.SECONDS)
			    .pollingEvery(1, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);

		wait.until(new Function<JavascriptExecutor, Boolean>() 
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
	
	protected boolean checkIfOnTopOfPage() {
		boolean onTop = false;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long value = (Long) executor.executeScript("return window.pageYOffset;");
		if(value==0) {
			onTop = true;
		}
		return onTop;
	}

	protected void scrollDownXFullScreenPageHeight(int x) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String scrollheight = (Integer.parseInt(fullScreenPageHeight)*x)+"";
		jse.executeScript("window.scrollBy(0,"+scrollheight+")", "");
		System.out.println("Scrolling");
	}
	protected void scrollDownXFullScreenPageHeightAndWait(int x) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String scrollheight = (Integer.parseInt(fullScreenPageHeight)*x)+"";
		System.out.println("Scrolling start: " + getPageYOffset());
		jse.executeScript("window.scrollBy(0,"+scrollheight+")", "");

		
		Wait<JavascriptExecutor> wait = new FluentWait<JavascriptExecutor>(jse)
			    .withTimeout(6, TimeUnit.SECONDS)
			    .pollingEvery(1, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);

		wait.until(new Function<JavascriptExecutor, Boolean>() 
		{
			public Boolean apply(JavascriptExecutor jseCopy) {
				boolean scrollStatus = jseCopy.executeScript("return document.readyState").toString().equals("complete");
				if(scrollStatus) {
					System.out.println("Finally done scrolling: " + getPageYOffset());
					return true;
				}else {
					System.out.println("Not done scrolling: " + getPageYOffset());
					return false;
				}
			}
		});	
	}
	protected void scrollDownXFullScreenPageHeightAndWait2(int x) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String scrollheight = (Integer.parseInt(fullScreenPageHeight)*x)+"";
		System.out.println("Scrolling start: " + getPageYOffset());
		jse.executeScript("window.scrollBy(0,"+scrollheight+")", "");

		Wait<JavascriptExecutor> wait = new FluentWait<JavascriptExecutor>(jse)
			    .withTimeout(6, TimeUnit.SECONDS)
			    .pollingEvery(1, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);

		wait.until(new Function<JavascriptExecutor, Boolean>() 
		{
			public Boolean apply(JavascriptExecutor jseCopy) {
				boolean scrollStatus = jseCopy.executeScript("return document.readyState").toString().equals("complete");
				if(scrollStatus) {
					System.out.println("Finally done scrolling: " + getPageYOffset());
					return true;
				}else {
					System.out.println("Not done scrolling: " + getPageYOffset());
					return false;
				}
			}
		});	
	}
	
	protected long getPageYOffset() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long value = (Long) executor.executeScript("return window.pageYOffset;");
		return value;
	}

	protected void checkNewTabNavigationOfElementTo() {
		//TODO
	}
	
	protected void checkInnerHtmlAccuracy() {
		//TODO
	}

	protected void checkLinkIsClickable() {
		//TODO
	}
	
	protected void checkSimilarImageOf() {
		//TODO
	}
	
	protected void checkNavigationOfElementTo() {
		//TODO	
	}
	
	protected void checkAddressOfPage(final String address) {
		FluentWait<String> fluentWaitAddressLoad;
		fluentWaitAddressLoad = new FluentWait<String>(address);
		fluentWaitAddressLoad.withTimeout(12000, TimeUnit.MILLISECONDS);
		fluentWaitAddressLoad.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitAddressLoad.ignoring(NoSuchElementException.class);
		Function<String, Boolean> isAddressLoaded = new Function<String,Boolean>(){
			public Boolean apply(String addressToCheck) {//shallow copy of address
				if(addressToCheck.equals(driver.getCurrentUrl())) {
					return true;
				}else {
					return false;
				}
			}
		};
//		fluentWaitAddressLoad.until(isAddressLoaded);	
		if(!(fluentWaitAddressLoad.until(isAddressLoaded))) {
			takeScreenshot();
		}
	}
		
	protected void waitForAnimationOfElement(String xpathExpression, String highlightImageSrc) {
		WebElement el = driver.findElement(By.xpath(xpathExpression));
		//TODO
		//define fluent wait
		FluentWait<WebElement> fluentWaitForAnimation;
		fluentWaitForAnimation = new FluentWait<WebElement>(el);
		fluentWaitForAnimation.withTimeout(12000, TimeUnit.MILLISECONDS);
		fluentWaitForAnimation.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForAnimation.ignoring(NoSuchElementException.class);
		Function<WebElement, Boolean> hasAnimationEnded = new Function<WebElement,Boolean>(){
			public Boolean apply(WebElement element) {//shallow copy of el
//				WebElement el = driver.findElement(By.xpath(elementXPath));
				return element.isDisplayed();
			}
		};
//		fluentWaitForAnimation.until(hasAnimationEnded);	
		if(!(fluentWaitForAnimation.until(hasAnimationEnded))) {
			takeScreenshot();
		}
	}
	
	protected void waitForAllAnimationsToFinish() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("return $(\":animated\").length == 0 ");
	}
	
	protected void clickButton(String xpathExpression) {
		WebElement el = driver.findElement(By.xpath(xpathExpression));
		
		//define fluent wait
		FluentWait<WebElement> fluentWaitForElement;
		fluentWaitForElement = new FluentWait<WebElement>(el);
		fluentWaitForElement.withTimeout(12000, TimeUnit.MILLISECONDS);
		fluentWaitForElement.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElement.ignoring(NoSuchElementException.class);
		Function<WebElement, Boolean> isElementDisplayed = new Function<WebElement,Boolean>(){
			public Boolean apply(WebElement element) {//shallow copy of el
//				WebElement el = driver.findElement(By.xpath(elementXPath));
				return element.isDisplayed();
			}
		};
//		fluentWaitForElement.until(isElementDisplayed);	
		if(!(fluentWaitForElement.until(isElementDisplayed))) {
			takeScreenshot();
		}
		el.click();
		//reset cursor to the top

	}

	protected void checkHighlightWhenHoveredOverOfElement(final String xpathExpression, final String highlightImageSrc) {
		WebElement el = driver.findElement(By.xpath(xpathExpression));
        Point classname = el.getLocation();
        int xcordi = classname.getX();
        int ycordi = classname.getY();
        System.out.println("Element is located at: " + xcordi + ": "+ycordi);
		Actions builder = new Actions(driver);
				
		//define fluent wait to check for presence of element
		FluentWait<WebElement> fluentWaitForElement;
		fluentWaitForElement = new FluentWait<WebElement>(el);
		fluentWaitForElement.withTimeout(12000, TimeUnit.MILLISECONDS);
		fluentWaitForElement.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElement.ignoring(NoSuchElementException.class);
		Function<WebElement, Boolean> isElementDisplayed = new Function<WebElement,Boolean>(){
			public Boolean apply(WebElement element) {//shallow copy of el
//				WebElement el = driver.findElement(By.xpath(elementXPath));
//				System.out.println(xpathExpression + " is displayed");
				return element.isDisplayed();
			}
		};
//		fluentWaitForElement.until(isElementDisplayed);	
		if(!(fluentWaitForElement.until(isElementDisplayed))) {
			takeScreenshot();
		}
		//move cursor to displayed element
		//Scrolling seems to mess with the bottom code
		el = driver.findElement(By.xpath(xpathExpression));
        classname = el.getLocation();
        xcordi = classname.getX();
        ycordi = classname.getY();
        System.out.println("Element is located at: " + xcordi + ": "+ycordi);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        classname = el.getLocation();
        xcordi = classname.getX();
        ycordi = classname.getY();
        System.out.println("Element is located at: " + xcordi + ": "+ycordi);
 
//		builder.moveToElement(el).click().build().perform();
		builder.moveToElement(el).perform();
		
		//define another fluent wait to check for highlighted image via sikuli
		FluentWait<String> fluentWaitForElementHighlight;
		fluentWaitForElementHighlight = new FluentWait<String>(highlightImageSrc);
		fluentWaitForElementHighlight.withTimeout(12000, TimeUnit.MILLISECONDS);
		fluentWaitForElementHighlight.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElementHighlight.ignoring(NoSuchElementException.class);
		Function<String, Boolean> isElementHighlighted = new Function<String,Boolean>(){
			public Boolean apply(String highlightImageSrcCopy) {
				//s.exists is what checks if the image stored is properly showing on the site
				if(s.exists(highlightImageSrcCopy)!=null) {
//					System.out.println(highlightImageSrc + " is displayed");
					return true;
				}else{
					//the screenshots aren't called every 250 milliseconds. It gets called once the fluentwait times out
					takeScreenshot();
					return false;				
				}

			}
		};
//		fluentWaitForElementHighlight.until(isElementHighlighted);
		if(!(fluentWaitForElementHighlight.until(isElementHighlighted))) {
			takeScreenshot();
		}
		//reset the highlighted Hamburger Button by moving to the top menu bar
		el = driver.findElement(By.id("menu_cont"));
		builder.moveToElement(el).perform();
	}
	protected void checkDehighlightWhenNoLongerHoveredOverOfElement(String xpathExpression, String highlightImageSrc, final String dehighlightImageSrc, final Region region) {
		WebElement el = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
				
		//define fluent wait to check for presence of element
		FluentWait<WebElement> fluentWaitForElement;
		fluentWaitForElement = new FluentWait<WebElement>(el);
		fluentWaitForElement.withTimeout(12000, TimeUnit.MILLISECONDS);
		fluentWaitForElement.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElement.ignoring(NoSuchElementException.class);
		Function<WebElement, Boolean> isElementDisplayed = new Function<WebElement,Boolean>(){
			public Boolean apply(WebElement element) {//shallow copy of el
//				WebElement el = driver.findElement(By.xpath(elementXPath));
				if(element.isDisplayed()) {
					return true;
				}else {
					return false;
				}
			}
		};
//		fluentWaitForElement.until(isElementDisplayed);//this should be displayed
		if(!(fluentWaitForElement.until(isElementDisplayed))) {
			takeScreenshot();
		}
		
		//move cursor to displayed element
		System.out.println("Clicking element");
		builder.moveToElement(el).perform();
		
		//define another fluent wait to check for highlighted image via sikuli
		FluentWait<String> fluentWaitForElementHighlight;
		fluentWaitForElementHighlight = new FluentWait<String>(highlightImageSrc);
		fluentWaitForElementHighlight.withTimeout(12000, TimeUnit.MILLISECONDS);
		fluentWaitForElementHighlight.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElementHighlight.ignoring(NoSuchElementException.class);
		Function<String, Boolean> isElementHighlighted = new Function<String,Boolean>(){
			public Boolean apply(String highlightImageSrcCopy) {
				//s.exists is what checks if the image stored is properly showing on the site
				if(s.exists(highlightImageSrcCopy)!=null) {
					return true;
				}else{
					//the screenshots aren't called every 250 milliseconds. It gets called once the fluentwait times out
//					takeScreenshot();
					return false;				
				}
			}
		};
//		fluentWaitForElementHighlight.until(isElementHighlighted);
		if(!(fluentWaitForElementHighlight.until(isElementHighlighted))) {
			takeScreenshot();
		}
		
		//reset the highlighted Hamburger Button by moving to the top menu bar
		el = driver.findElement(By.id("menu_cont"));
		builder.moveToElement(el).perform();
		
		//define another fluent wait to check for dehighlighted image via sikuli
		FluentWait<String> fluentWaitForElementDehighlight;
		fluentWaitForElementDehighlight = new FluentWait<String>(dehighlightImageSrc);
		fluentWaitForElementDehighlight.withTimeout(12000, TimeUnit.MILLISECONDS);
		fluentWaitForElementDehighlight.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElementDehighlight.ignoring(NoSuchElementException.class);
		Function<String, Boolean> isElementDehighlighted = new Function<String,Boolean>(){
			public Boolean apply(String dehighlightImageSrcCopy) {
				Match m = region.exists(dehighlightImageSrcCopy);
//				region.highlight();
				if(m!=null){
					return true;
				}else{
					//the screenshots aren't called every 250 milliseconds. It gets called once the fluentwait times out
//					System.out.println("Error at: " + Thread.currentThread().getStackTrace()[1].getMethodName());
//					takeScreenshot();
					return false;			
				}
			}
		};
//		fluentWaitForElementDehighlight.until(isElementDehighlighted);
		if(!(fluentWaitForElementDehighlight.until(isElementDehighlighted))) {
			takeScreenshot();
		}
	}
	protected void checkPageBackgroundIsDisplayed(String backgroundSrc) {		
		//define fluent wait
		FluentWait<String> fluentWaitForBackground;
		fluentWaitForBackground = new FluentWait<String>(backgroundSrc);
		fluentWaitForBackground.withTimeout(12000, TimeUnit.MILLISECONDS);
		fluentWaitForBackground.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForBackground.ignoring(NoSuchElementException.class);
		Function<String, Boolean> isBackgroundDisplayed = new Function<String,Boolean>(){
			public Boolean apply(String backgroundSrcCopy) {
				//s.exists is what checks if the background stored is properly showing on the site
				if(s.exists(backgroundSrcCopy)!=null) {
					return true;
				}else{					
					return false;	
				}//the screenshots aren't called every 250 milliseconds. It gets called once the fluentwait times out

			}
		};
		if(!(fluentWaitForBackground.until(isBackgroundDisplayed))) {
			takeScreenshot();
		}
	}
	/** Sikuli+FluentWait check if imageSrc exists in region defined by upper left corner(x,y) with width and height in pixels
	 * @param imageSrc
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	protected void checkPageImageIsDisplayed(String imageSrc, final int x, final int y, final int width, final int height) {		
		//define fluent wait
		FluentWait<String> fluentWaitForBackground;
		fluentWaitForBackground = new FluentWait<String>(imageSrc);
		fluentWaitForBackground.withTimeout(12000, TimeUnit.MILLISECONDS);
		fluentWaitForBackground.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForBackground.ignoring(NoSuchElementException.class);
		Function<String, Boolean> isBackgroundDisplayed = new Function<String,Boolean>(){
			public Boolean apply(String imageSrcCopy) {
				//TODO - Region needs to be parameterized - allows for less false positives
//				Region r = Region.create(1500,0,420,1200);
				Region r = Region.create(x, y, width, height);
				if(r.exists(imageSrcCopy)!=null) {
					return true;
				}else{
					//the screenshots aren't called every 250 milliseconds. It gets called once the fluentwait times out
					takeScreenshot();
					return false;	
				}

			}
		};
		fluentWaitForBackground.until(isBackgroundDisplayed);
	}
	protected void checkPageBackgroundIsNotVisible(String backgroundSrc, String omitSrc) {
//		//define fluent wait
//		FluentWait<String> fluentWaitForBackground;
//		fluentWaitForBackground = new FluentWait<String>(backgroundSrc);
//		fluentWaitForBackground.withTimeout(2500, TimeUnit.MILLISECONDS);
//		fluentWaitForBackground.pollingEvery(250, TimeUnit.MILLISECONDS);
//		fluentWaitForBackground.ignoring(NoSuchElementException.class);
//		Function<String, Boolean> isBackgroundNotVisible = new Function<String,Boolean>(){
//			public Boolean apply(String backgroundSrcCopy) {
//				//s.exists is what checks if the background stored is properly showing on the site
//				if(!(s.exists(backgroundSrcCopy)!=null)) {//this can lead to false positives, how about just checking the background with a reference to no menu?
//					return true;
//				}
//				else{//the screenshots aren't called every 250 milliseconds. It gets called once the fluentwait times out
//					takeScreenshot();
//					return false;
//				}
//			}
//		};
//		fluentWaitForBackground.until(isBackgroundNotVisible);
		
		//for now, omitSrc is not going to be used
		checkPageBackgroundIsDisplayed(backgroundSrc);
	}
	
	protected void clickBackButton() {
		driver.navigate().back();	
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
	//from https://stackoverflow.com/questions/45243992/verification-of-element-in-viewport-in-selenium
	public static Boolean isVisibleInViewport(WebElement element) {
		  WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();

		  return (Boolean)((JavascriptExecutor)driver).executeScript(
		      "var elem = arguments[0],                 " +
		      "  box = elem.getBoundingClientRect(),    " +
		      "  cx = box.left + box.width / 2,         " +
		      "  cy = box.top + box.height / 2,         " +
		      "  e = document.elementFromPoint(cx, cy); " +
		      "for (; e; e = e.parentElement) {         " +
		      "  if (e === elem)                        " +
		      "    return true;                         " +
		      "}                                        " +
		      "return false;                            "
		      , element);
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
}

