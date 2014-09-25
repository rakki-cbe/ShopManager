package com.SRMTechnology.inventorymanager.Fragments;

import com.SRMTechnology.inventorymanager.R;
import com.SRMTechnology.inventorymanager.R.array;
import com.SRMTechnology.inventorymanager.R.id;
import com.SRMTechnology.inventorymanager.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainScreen extends Fragment{
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		// Retrieving the currently selected item number
		int position = getArguments().getInt("position");
		
		// List of rivers
		String[] countries = getResources().getStringArray(R.array.countries);
		
		// Creating view correspoding to the fragment
		View v = inflater.inflate(R.layout.fragment_main_screen, container, false);
		
		
		
		return v;
	}
}