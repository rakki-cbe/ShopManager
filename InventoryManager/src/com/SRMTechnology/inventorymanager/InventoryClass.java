package com.SRMTechnology.inventorymanager;

import com.parse.Parse;

import android.app.Application;

public class InventoryClass extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Parse.initialize(this, "RZc6V8ARpWZ68k9qlkcwOlnhmFU9jqQWHmiKGhWP", "8WJFAmPwKBqtJhVxDj9Ul9SA8L1JPhry21NWD15k");
	}

}
