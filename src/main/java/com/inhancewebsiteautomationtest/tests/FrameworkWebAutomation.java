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
import org.openqa.selenium.chrome.ChromeDriver;
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

public class FrameworkWebAutomation {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	protected WebDriverWait wait;	
	protected int waitInSecondsForBackground;
	protected int waitForDynamicElement;

	protected Region upperHalf;
	protected Region lowerHalf;
	protected Region leftHalf;
	protected Region rightHalf;
	protected Region fullScreen;
	protected int resolutionWidth;
	protected int resolutionHeight;
	protected int viewportWidth;
	protected int viewportHeight;
	protected Screen s;

	FrameworkWebAutomation(){
		//TODO will have to make global field values externally input-able
	
		waitInSecondsForBackground = 10;
		waitForDynamicElement = 6;
		viewportHeight = 1086;
		
		s  = new Screen();		
		
		ImagePath.add(MainOne.class.getCanonicalName()+"/images");

		resolutionWidth = 1920;
		resolutionHeight = 1200;
		
		upperHalf = new Region(0,0,resolutionWidth, resolutionHeight/2);
//		upperHalf.highlight();
		lowerHalf = new Region(0,resolutionHeight/2, resolutionWidth, resolutionHeight/2);
//		lowerHalf.highlight();
		leftHalf = new Region(0,0,resolutionWidth/2, resolutionHeight);
//		leftHalf.highlight();
		rightHalf = new Region(resolutionWidth/2,0,resolutionWidth/2, resolutionHeight);
//		rightHalf.highlight();
		fullScreen = new Region(0,0, resolutionWidth, resolutionHeight);
	}
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {	
		ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("chromedriver.exe");
        String os = System.getProperty("os.name").toLowerCase();
        File f = new File("Driver");
        if (!f.exists()) {
            f.mkdirs();
        }
        File chromedriver;

        //In the case of a MAC, we may need to copy the tar.gz file and then reference the resulting geckodriver application
        if(os.contains("mac")) {
        	chromedriver = new File(System.getProperty("user.dir") + "/chromedriver");  
        }else {
        	chromedriver = new File("Driver" + "\\chromedriver.exe"); 
            if (!chromedriver.exists()) {
            	chromedriver.createNewFile();
                FileUtils.copyURLToFile(resource, chromedriver);
            }
        }

        String chromedriverLocation = chromedriver.getAbsolutePath();        
        System.setProperty("webdriver.chrome.driver", chromedriverLocation);
        
	    driver = new ChromeDriver();
	    baseUrl = "localhost:8080/test.html";
	    driver.get(baseUrl);
	    //TODO Window size options
	    driver.manage().window().maximize(); 
//	    driver.manage().window().setSize(new Dimension(1024, 768))
	    wait = new WebDriverWait(driver, 20);
	}

	//the below functions are independent of each other
	//this would solve TestNG's seemingly random execution order of tests, as well as ease of reportability and reproducibility
	//the format would be given_Location_when_Action_then_Result
	//TODO
//		@Test
//		protected void given_condition_when_action_then_result() {
//	
//		}
	
	@Test
	protected void test() {
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		executor.executeScript("visualizer.setVisualizer({Product_Category__c: 'Awning', Product_Sub_Category__c: 'Awning', Interior_Color__c: 'Oak'})");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.executeScript("visualizer.setVisualizer({Sales_Width_Inches__c: 17, Sales_Height_Inches__c: 28, Interior_Color__c: 'Oak', Exterior_Color__c: 'Terratone®', Glass_Pattern_S1__c: 'Reed', Sash_Ratio__: '1:2', Clone__c: '1'})");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	protected void scrollDownXFullScreenPageHeightAndWait(int x) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String scrollheight = viewportHeight*x+"";
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
		String scrollheight = viewportHeight*x+"";
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

