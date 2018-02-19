package com.inhancewebsiteautomationtest.tests;


public class MainOne {
	public static void main(String[] args) {	
		System.out.println( "Test Started \n\n" );
		
		AutomationTestSeleniumFormatted automationTestSeleniumFormatted = new AutomationTestSeleniumFormatted();
		try {
			automationTestSeleniumFormatted.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		automationTestSeleniumFormatted.homeSmokeTest();
//		automationTestSeleniumFormatted.checkHomeBackground();
		
		automationTestSeleniumFormatted.workSmokeTest();
//		automationTestSeleniumFormatted.clickHamburgerButton();
//		automationTestSeleniumFormatted.clickWorkButton();
//		automationTestSeleniumFormatted.checkWorkBackground();
//		automationTestSeleniumFormatted.clickBackButton();
		
		automationTestSeleniumFormatted.aboutSmokeTest();
//		automationTestSeleniumFormatted.clickHamburgerButton();
//		automationTestSeleniumFormatted.clickAboutButton();
//		automationTestSeleniumFormatted.checkAboutBackground();
//		automationTestSeleniumFormatted.clickBackButton();
		
		automationTestSeleniumFormatted.newsSmokeTest();
//		automationTestSeleniumFormatted.clickHamburgerButton();
//		automationTestSeleniumFormatted.clickNewsButton();
//		automationTestSeleniumFormatted.checkNewsBackground();
//		automationTestSeleniumFormatted.clickBackButton();
		
		automationTestSeleniumFormatted.contactSmokeTest();
//		automationTestSeleniumFormatted.clickHamburgerButton();
//		automationTestSeleniumFormatted.clickContactButton();
//		automationTestSeleniumFormatted.checkContactBackground();
//		automationTestSeleniumFormatted.clickBackButton();
		
		try {
			automationTestSeleniumFormatted.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println( "All Tests Successful \n\n" );//still gets outputted even if tests fail
	}

}
