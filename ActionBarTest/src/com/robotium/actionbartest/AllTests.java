package com.robotium.actionbartest;

import junit.framework.TestSuite;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

public class AllTests extends  ActivityInstrumentationTestCase2<Activity> {
	
	

	public AllTests(Class<Activity> activityClass) {
		super(activityClass);
	}

	public static TestSuite suite() {
		TestSuite t = new TestSuite();
		t.addTestSuite(MainActivityTest.class);
		t.addTestSuite(MapActivityTest.class);
		
		return t; 
	}
	
	@Override
	public void setUp() throws Exception {
		
	}
	
	
	@Override
	public void tearDown() throws Exception {
	}

}