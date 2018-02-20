package com.inhancewebsiteautomationtest.tests;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class MainHomeTest {
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { InhanceWebsiteHomePageTest.class });
		testng.addListener(tla);
		testng.run();
	}
}