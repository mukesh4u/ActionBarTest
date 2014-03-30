package com.robotium.actionbartest;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.example.actionbar.Map;
import com.robotium.solo.Solo;

public class MapActivityTest extends ActivityInstrumentationTestCase2<Map> {
	private Solo solo;
	private Activity activity;

	public MapActivityTest() {
		super(Map.class);
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
}
