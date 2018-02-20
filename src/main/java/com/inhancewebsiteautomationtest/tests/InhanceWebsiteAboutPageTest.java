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

public class InhanceWebsiteAboutPageTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	WebDriverWait wait;	
	int waitInSecondsForBackground;
	int waitForDynamicElement;
	String fullScreenPageHeight;	
	String workBackground;
	String aboutBackground;
	String newsBackground;
	String contactBackground;
	String careersBackground1a;//since the content in the careers page changes regularly, we can only check 
	String careersBackground1b;
	String logoButtonHomeHighlighted;
	String logoButtonWorkHighlighted;
	String logoButtonAboutHighlighted;
	String logoButtonAboutDehighlighted;
	String logoButtonNewsHighlighted;
	String logoButtonContactHighlighted;	
	String hamburgerButton;
	String hamburgerButtonHighlighted;
	String hamburgerButtonDehighlighted;
	String aboutHamburgerButtonHighlighted;
	String aboutHamburgerButtonDehighlighted;
	String hamburgerMenu;
	String hamburgerMenuWorkHighlight;
	String hamburgerMenuAboutHighlight;
	String hamburgerMenuNewsHighlight;
	String hamburgerMenuContactHighlight;
	String xButton;
	String homePageAddress;
	String workPageAddress;
	String aboutPageAddress;
	String newsPageAddress;
	String contactPageAddress;
	String careersPageAddress;
	String facebookAddress;
	String twitterAddress;
	String linkedInBaseAddress;
	String linkedInAddress;
	String linkedInAlternateAddress;
	String companyPhoneNumber;
	String companyEmail;
	Screen s;
	FluentWait<String> fluentWaitForBackground;
	
	String hamburgerXPath;
	String aboutXPath;
	String logoXPath;

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
		logoButtonAboutDehighlighted = "1519087671910.png";
		logoButtonNewsHighlighted = "1518567554753.png";
		logoButtonContactHighlighted = "1518567568493.png";
		hamburgerButton = "1518561439335.png";
		hamburgerButtonHighlighted = "1518561729060.png";
		aboutHamburgerButtonHighlighted = "1519089955933.png";
		aboutHamburgerButtonDehighlighted = "1519089770236.png";
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
		logoXPath = "//div[@id='logo']";
		
//		//replaces Wait
//		//copy the entirety of it and replace xpathExpression
//		FluentWait<String> fluentWaitForElement;
//		fluentWaitForElement = new FluentWait(xpathExpression);
//		fluentWaitForElement.withTimeout(5000, TimeUnit.MILLISECONDS);
//		fluentWaitForElement.pollingEvery(250, TimeUnit.MILLISECONDS);
//		fluentWaitForElement.ignoring(NoSuchElementException.class);
//		Function<String, Boolean> isElementDisplayed = new Function<String,Boolean>(){
//			public Boolean apply(String img) {
//				WebElement el = driver.findElement(By.xpath(xpathExpression));
//				return el.isDisplayed();
//			}
//		};
//		fluentWaitForElement.until(isElementDisplayed);
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
//		checkHighlightWhenHoveredOverOfElement(logoXPath, logoButtonAboutHighlighted);
//	}
//	@Test 
//	protected void given_AboutLogoButton_when_Unhovered_then_Dehighlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(logoXPath, logoButtonAboutHighlighted, logoButtonAboutDehighlighted);
//	}	
//	@Test 
//	protected void given_AboutHamburgerButton_when_Hovered_then_Highlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkHighlightWhenHoveredOverOfElement(hamburgerXPath, aboutHamburgerButtonHighlighted);
//	}
//	@Test 
//	protected void given_AboutHamburgerButton_when_Unhovered_then_Dehighlighted(){
//		clickButton(hamburgerXPath);
//		clickButton(aboutXPath);
//		checkDehighlightWhenNoLongerHoveredOverOfElement(hamburgerXPath, aboutHamburgerButtonHighlighted,aboutHamburgerButtonDehighlighted);
//	}
	@Test 
	protected void given_AboutHamburgerButton_when_Pressed_then_MenuIsDisplayed(){
		clickButton(hamburgerXPath);
		clickButton(aboutXPath);
		checkPageBackgroundIsDisplayed(hamburgerMenu);
	}
	@Test 
	protected void given_AboutHamburgerButtonXSelection_when_Action_then_Result(){
		
	}
//	@Test protected void given_AboutHamburgerButtonWorkSelection_when_Action_then_Result(){}
//	@Test protected void given_AboutHamburgerButtonAboutSelection_when_Action_then_Result(){}
//	@Test protected void given_AboutHamburgerButtonNewsSelection_when_Action_then_Result(){}
//	@Test protected void given_AboutHamburgerButtonContactSelection_when_Action_then_Result(){}
//	@Test protected void given_AboutDownArrowButton_when_Action_then_Result(){}
//	@Test protected void given_AboutAerospaceLink_when_Action_then_Result(){}
//	@Test protected void given_AboutITTelecomLink_when_Action_then_Result(){}
//	@Test protected void given_AboutHealthcareLink_when_Action_then_Result(){}
//	@Test protected void given_AboutEnergyLink_when_Action_then_Result(){}
//	@Test protected void given_AboutAutomotiveLink_when_Action_then_Result(){}
//	@Test protected void given_AboutMoreButton_when_Action_then_Result(){}
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
		fluentWaitAddressLoad.withTimeout(6000, TimeUnit.MILLISECONDS);
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
		fluentWaitAddressLoad.until(isAddressLoaded);	
	}
		
	protected void waitForAnimationOfElement(String xpathExpression, String highlightImageSrc) {
		WebElement el = driver.findElement(By.xpath(xpathExpression));
		//TODO
		//define fluent wait
		FluentWait<WebElement> fluentWaitForAnimation;
		fluentWaitForAnimation = new FluentWait<WebElement>(el);
		fluentWaitForAnimation.withTimeout(6000, TimeUnit.MILLISECONDS);
		fluentWaitForAnimation.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForAnimation.ignoring(NoSuchElementException.class);
		Function<WebElement, Boolean> hasAnimationEnded = new Function<WebElement,Boolean>(){
			public Boolean apply(WebElement element) {//shallow copy of el
//				WebElement el = driver.findElement(By.xpath(elementXPath));
				return element.isDisplayed();
			}
		};
		fluentWaitForAnimation.until(hasAnimationEnded);	
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
		fluentWaitForElement.withTimeout(6000, TimeUnit.MILLISECONDS);
		fluentWaitForElement.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElement.ignoring(NoSuchElementException.class);
		Function<WebElement, Boolean> isElementDisplayed = new Function<WebElement,Boolean>(){
			public Boolean apply(WebElement element) {//shallow copy of el
//				WebElement el = driver.findElement(By.xpath(elementXPath));
				return element.isDisplayed();
			}
		};
		fluentWaitForElement.until(isElementDisplayed);	
		
		el.click();
	}

	protected void checkHighlightWhenHoveredOverOfElement(String xpathExpression, String highlightImageSrc) {
		WebElement el = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
				
		//define fluent wait to check for presence of element
		FluentWait<WebElement> fluentWaitForElement;
		fluentWaitForElement = new FluentWait<WebElement>(el);
		fluentWaitForElement.withTimeout(6000, TimeUnit.MILLISECONDS);
		fluentWaitForElement.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElement.ignoring(NoSuchElementException.class);
		Function<WebElement, Boolean> isElementDisplayed = new Function<WebElement,Boolean>(){
			public Boolean apply(WebElement element) {//shallow copy of el
//				WebElement el = driver.findElement(By.xpath(elementXPath));
				return element.isDisplayed();
			}
		};
		fluentWaitForElement.until(isElementDisplayed);	
		
		//move cursor to displayed element
		builder.moveToElement(el).perform();
		
		//define another fluent wait to check for highlighted image via sikuli
		FluentWait<String> fluentWaitForElementHighlight;
		fluentWaitForElementHighlight = new FluentWait<String>(highlightImageSrc);
		fluentWaitForElementHighlight.withTimeout(6000, TimeUnit.MILLISECONDS);
		fluentWaitForElementHighlight.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElementHighlight.ignoring(NoSuchElementException.class);
		Function<String, Boolean> isElementHighlighted = new Function<String,Boolean>(){
			public Boolean apply(String highlightImageSrc) {
				//s.exists is what checks if the image stored is properly showing on the site
				if(s.exists(highlightImageSrc)!=null) {
					return true;
				}
				//the screenshots aren't called every 250 milliseconds. It gets called once the fluentwait times out
				takeScreenshot();
				return false;
			}
		};
		fluentWaitForElementHighlight.until(isElementHighlighted);
		
		//reset the highlighted Hamburger Button by moving to the top menu bar
		el = driver.findElement(By.id("menu_cont"));
		builder.moveToElement(el).perform();
	}
	protected void checkDehighlightWhenNoLongerHoveredOverOfElement(String xpathExpression, String highlightImageSrc, String dehighlightImageSrc) {
		WebElement el = driver.findElement(By.xpath(xpathExpression));
		Actions builder = new Actions(driver);
				
		//define fluent wait to check for presence of element
		FluentWait<WebElement> fluentWaitForElement;
		fluentWaitForElement = new FluentWait<WebElement>(el);
		fluentWaitForElement.withTimeout(6000, TimeUnit.MILLISECONDS);
		fluentWaitForElement.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElement.ignoring(NoSuchElementException.class);
		Function<WebElement, Boolean> isElementDisplayed = new Function<WebElement,Boolean>(){
			public Boolean apply(WebElement element) {//shallow copy of el
//				WebElement el = driver.findElement(By.xpath(elementXPath));
				return element.isDisplayed();
			}
		};
		fluentWaitForElement.until(isElementDisplayed);	
		
		//move cursor to displayed element
		builder.moveToElement(el).perform();
		
		//define another fluent wait to check for highlighted image via sikuli
		FluentWait<String> fluentWaitForElementHighlight;
		fluentWaitForElementHighlight = new FluentWait<String>(highlightImageSrc);
		fluentWaitForElementHighlight.withTimeout(6000, TimeUnit.MILLISECONDS);
		fluentWaitForElementHighlight.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElementHighlight.ignoring(NoSuchElementException.class);
		Function<String, Boolean> isElementHighlighted = new Function<String,Boolean>(){
			public Boolean apply(String highlightImageSrcCopy) {
				//s.exists is what checks if the image stored is properly showing on the site
				if(s.exists(highlightImageSrcCopy)!=null) {
					return true;
				}
				//the screenshots aren't called every 250 milliseconds. It gets called once the fluentwait times out
				takeScreenshot();
				return false;
			}
		};
		fluentWaitForElementHighlight.until(isElementHighlighted);
		
		//reset the highlighted Hamburger Button by moving to the top menu bar
		el = driver.findElement(By.id("menu_cont"));
		builder.moveToElement(el).perform();
		
		//define another fluent wait to check for dehighlighted image via sikuli
		FluentWait<String> fluentWaitForElementDehighlight;
		fluentWaitForElementDehighlight = new FluentWait<String>(dehighlightImageSrc);
		fluentWaitForElementDehighlight.withTimeout(6000, TimeUnit.MILLISECONDS);
		fluentWaitForElementDehighlight.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForElementDehighlight.ignoring(NoSuchElementException.class);
		Function<String, Boolean> isElementDehighlighted = new Function<String,Boolean>(){
			public Boolean apply(String dehighlightImageSrcCopy) {
				//s.exists is what checks if the image stored is properly showing on the site
				if(s.exists(dehighlightImageSrcCopy)!=null) {
					return true;
				}
				//the screenshots aren't called every 250 milliseconds. It gets called once the fluentwait times out
				takeScreenshot();
				return false;
			}
		};
		fluentWaitForElementDehighlight.until(isElementDehighlighted);
	}
	protected void checkPageBackgroundIsDisplayed(final String backgroundSrc) {		
		//define fluent wait
		FluentWait<String> fluentWaitForBackground;
		fluentWaitForBackground = new FluentWait<String>(backgroundSrc);
		fluentWaitForBackground.withTimeout(2500, TimeUnit.MILLISECONDS);
		fluentWaitForBackground.pollingEvery(250, TimeUnit.MILLISECONDS);
		fluentWaitForBackground.ignoring(NoSuchElementException.class);
		Function<String, Boolean> isBackgroundDisplayed = new Function<String,Boolean>(){
			public Boolean apply(String backgroundSrcCopy) {
				//s.exists is what checks if the background stored is properly showing on the site
				if(s.exists(backgroundSrcCopy)!=null) {
					return true;
				}
				//the screenshots aren't called every 250 milliseconds. It gets called once the fluentwait times out
				takeScreenshot();
				return false;
			}
		};
		fluentWaitForBackground.until(isBackgroundDisplayed);
		
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

