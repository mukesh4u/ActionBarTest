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

import com.example.actionbar.Map;
import com.robotium.solo.Solo;

/**
 * @author Mukesh Y
 */
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
