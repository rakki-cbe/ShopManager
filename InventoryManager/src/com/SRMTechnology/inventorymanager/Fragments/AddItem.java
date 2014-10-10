package com.SRMTechnology.inventorymanager.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.SRMTechnology.inventorymanager.R;

public class AddItem extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		// Retrieving the currently selected item number
		View v = inflater.inflate(R.layout.fragment_additem, container, false);
				
		return v;
	}

}
