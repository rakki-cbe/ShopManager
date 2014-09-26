package com.SRMTechnology.inventorymanager.Fragments;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.SRMTechnology.inventorymanager.R;
import com.SRMTechnology.inventorymanager.XLconverter.ImportXL;

public class MainScreen extends Fragment{
	
	ImportXL XL;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		// Retrieving the currently selected item number
		View v = inflater.inflate(R.layout.fragment_main_screen, container, false);
		XL=new ImportXL(Environment.getExternalStorageDirectory()+"/testbook.xls");
		int position = getArguments().getInt("position");
		String stringa1 = XL.getString(0, 0); 
		((TextView)v.findViewById(R.id.testscreen)).setText(stringa1);
				
		return v;
	}
}