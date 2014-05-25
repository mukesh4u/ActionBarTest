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
package com.example.actionbar;

import android.R.integer;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.actionbarsherlock.view.SubMenu;

/**
 * @author Mukesh Y
 */
public class MainActivity extends SherlockActivity implements
		OnMenuItemClickListener {

	private SubMenu mSortItem;
	private MenuItem mMapItem;
	private int MAP_ID = 101;
	private int SORT_ID = 102;

	CharSequence selected = "Light";
	TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_main);

		mTextView = (TextView)findViewById(R.id.theme);
		ActionBar ab = getSupportActionBar();
		ab.setBackgroundDrawable(getApplicationContext().getResources()
				.getDrawable(R.drawable.bg_titlebar_tile));
		ab.setDisplayShowTitleEnabled(true);
		mTextView.setText(selected);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		mSortItem = menu.addSubMenu(0,SORT_ID,0,selected);
		mSortItem.setIcon(R.drawable.ic_menu_sort);
		
		mSortItem.getItem().setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM
						| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		mMapItem = menu.add(0, MAP_ID, 0, "map");
		mMapItem.setIcon(R.drawable.google_maps_icon_pressed)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		getMenuState("Light");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId()==mMapItem.getItemId()) {
			Intent mapIntent = new Intent(this, Map.class);
			startActivity(mapIntent);
		} else {

		}
		return true;
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		mSortItem.clear();
		getMenuState(item.getTitle());
		return false;
	}

	public void getMenuState(CharSequence selected) {
		mTextView.setText(selected);
		if (selected.equals("Default")) {
			mSortItem.add(0, R.style.Theme_Sherlock, 0, "Default")
					.setIcon(android.R.drawable.checkbox_on_background)
					.setOnMenuItemClickListener(this);
			mSortItem.add(0, R.style.Theme_Sherlock_Light, 0, "Light")
					.setIcon(android.R.drawable.checkbox_off_background)
					.setOnMenuItemClickListener(this);
			mSortItem.add(0, R.style.Theme_Sherlock_Light_DarkActionBar, 0, "Light (Dark Action Bar)")
					.setIcon(android.R.drawable.checkbox_off_background)
					.setOnMenuItemClickListener(this);
			
			setTheme(R.style.Theme_Sherlock);
		} else if (selected.equals("Light")) {
			mSortItem.add(0, R.style.Theme_Sherlock, 0, "Default")
					.setIcon(android.R.drawable.checkbox_off_background)
					.setOnMenuItemClickListener(this);
			mSortItem.add(0, R.style.Theme_Sherlock_Light, 0, "Light")
					.setIcon(android.R.drawable.checkbox_on_background)
					.setOnMenuItemClickListener(this);
			mSortItem.add(0, R.style.Theme_Sherlock_Light_DarkActionBar, 0, "Light (Dark Action Bar)")
					.setIcon(android.R.drawable.checkbox_off_background)
					.setOnMenuItemClickListener(this);
			setTheme(R.style.Theme_Sherlock_Light);
		} else {
			mSortItem.add("Default")
					.setIcon(android.R.drawable.checkbox_off_background)
					.setOnMenuItemClickListener(this);
			mSortItem.add(0, R.style.Theme_Sherlock_Light, 0, "Light")
					.setIcon(android.R.drawable.checkbox_off_background)
					.setOnMenuItemClickListener(this);
			mSortItem.add(0, R.style.Theme_Sherlock_Light_DarkActionBar, 0, "Light (Dark Action Bar)")
					.setIcon(android.R.drawable.checkbox_on_background)
					.setOnMenuItemClickListener(this);
			setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		}

	}
}