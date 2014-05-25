/*
 * Copyright (C) 2014 Mukesh Y authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.robotium.actionbartest;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.example.actionbar.MainActivity;
import com.example.actionbar.Map;
import com.robotium.solo.Solo;

/**
 * @author Mukesh Y
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;
	private Activity activity;

	public MainActivityTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp() throws Exception {
		activity = this.getActivity();
		solo = new Solo(getInstrumentation(), activity);
	}
	
	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
	
	public void testShouldDisplayMapActivity() throws Exception {
		solo.clickOnActionBarItem(101);
		solo.waitForActivity(Map.class, 200);
		solo.assertCurrentActivity("Expected activity is:",
				Map.class);
		solo.waitForActivity(solo.getCurrentActivity().toString());
		solo.goBack();
	}
	
	public void testShouldShowDefultTheme() throws Exception {
		solo.clickOnActionBarItem(102);
		solo.clickOnMenuItem("Default");
		assertTrue(solo.searchText("Default"));
	}

	public void testShouldShowLightTheme() throws Exception {
		solo.clickOnActionBarItem(102);
		solo.clickOnMenuItem("Light");
		assertTrue(solo.searchText("Light"));
	}
	
	public void testShouldShowDarkTheme() throws Exception {
		solo.clickOnActionBarItem(102);
		solo.clickOnMenuItem("Light (Dark Action Bar)");
		assertTrue(solo.searchText("Light (Dark Action Bar)"));
	}
}
