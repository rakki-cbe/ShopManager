/**
 * @author Radhakrishnan S
 * Created Date :26-Sep-2014
 * Purpose : Navigation drawer options
 * 
 */
package com.SRMTechnology.inventorymanager.Addapters;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.SRMTechnology.inventorymanager.R;
import com.SRMTechnology.inventorymanager.helperclass.MenuString;

public class MenuBarOptions extends BaseAdapter {
Context context;
MenuString values[];
LayoutInflater inflater;
holder h;
public MenuBarOptions(Context context,MenuString[] values) {
	super();
	this.context = context;
	this.values = values;
	inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}


	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.values.length;
	}

	@Override
	public MenuString getItem(int position) {
		// TODO Auto-generated method stub
		return this.values[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
	     
		    // First let's verify the convertView is not null
		    if (convertView == null) {
		        // This a new view we inflate the new layout
		        
		    	convertView = inflater.inflate(R.layout.addapter_menu_item, null);
		    	h = new holder();
		    	h.TVTitle=(TextView) convertView.findViewById(R.id.Title);
		    	h.TVContent=(TextView) convertView.findViewById(R.id.Option);
		    	convertView.setTag(h); 
		        
		    }
		    else
		    {
		        h = (holder) convertView.getTag();
		    }
		    MenuString cur=values[position];
		    h.TVTitle.setText(cur.getDisplayName());
		    h.TVContent.setText(cur.getDisplayName());
		    if(cur.getCharctor()==1)
		    {
		    	h.TVContent.setVisibility(View.GONE);
		    	h.TVTitle.setVisibility(View.VISIBLE);
		    	
		    }
		    else if(cur.getCharctor()==2)
		    {
		    	h.TVContent.setVisibility(View.VISIBLE);
		    	h.TVTitle.setVisibility(View.GONE);
		    }
		    	
		return convertView;
	}

	class holder 
	{
		TextView TVTitle,TVContent;
		
	}

}
