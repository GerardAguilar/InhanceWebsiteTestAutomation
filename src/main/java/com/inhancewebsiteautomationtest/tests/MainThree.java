package com.inhancewebsiteautomationtest.tests;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class MainThree {
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { InhanceWebsiteMainTest.class });
		testng.addListener(tla);
		testng.run();
	}
}