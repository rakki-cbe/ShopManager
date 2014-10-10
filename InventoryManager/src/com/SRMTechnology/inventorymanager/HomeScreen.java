/**
 * @author Radhakrishnan S
 * Created Date :24-Sep-2014
 * Purpose : Home Screen for manage all the activity
 * 
 */
package com.SRMTechnology.inventorymanager;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.SRMTechnology.inventorymanager.Addapters.MenuBarOptions;
import com.SRMTechnology.inventorymanager.Fragments.AddItem;
import com.SRMTechnology.inventorymanager.Fragments.MainScreen;
import com.SRMTechnology.inventorymanager.helperclass.MenuString;

import android.R.anim;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class HomeScreen extends ActionBarActivity {
	// Array of strings storing country names
    MenuString[] MenuOption ;
    int mPosition = -1;	
	String mTitle = "";
   
	
	private DrawerLayout mDrawerLayout;	
	private ListView mDrawerList;	
	private ActionBarDrawerToggle mDrawerToggle;	
	private LinearLayout mDrawer ;	
	private List<HashMap<String,String>> mList ;	
	private MenuBarOptions mAdapter;	
	final private String COUNTRY = "country";	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		// Getting an array of country names
				getMenuOption();
				
				// Title of the activity
				mTitle = (String)getTitle();
				
				// Getting a reference to the drawer listview
				mDrawerList = (ListView) findViewById(R.id.drawer_list);
				
				// Getting a reference to the sidebar drawer ( Title + ListView )
				mDrawer = ( LinearLayout) findViewById(R.id.drawer);
				
				
		        mAdapter = new MenuBarOptions(this, MenuOption); 
		        
		        // Getting reference to DrawerLayout
		        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);        
		        
		        // Creating a ToggleButton for NavigationDrawer with drawer event listener
		        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer , R.string.drawer_open,R.string.drawer_close){
		        	
		        	 /** Called when drawer is closed */
		            public void onDrawerClosed(View view) {               
		            	highlightSelectedCountry();            		
		                supportInvalidateOptionsMenu();       
		            }

		            /** Called when a drawer is opened */
		            public void onDrawerOpened(View drawerView) {            	
		                getSupportActionBar().setTitle(getString(R.string.app_name));            	
		            	supportInvalidateOptionsMenu();                
		            }
		        };
		        
		        // Setting event listener for the drawer
		        mDrawerLayout.setDrawerListener(mDrawerToggle);
		        
		        // ItemClick event handler for the drawer items
		        mDrawerList.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int position,
							long arg3) {
						showFragment(position);
						 
					
						// Closing the drawer
						mDrawerLayout.closeDrawer(mDrawer);		
					}
				});
		        
		        
		        // Enabling Up navigation
		        getSupportActionBar().setDisplayHomeAsUpEnabled(true);     
		        
		        getSupportActionBar().setDisplayShowHomeEnabled(true);        

		        // Setting the adapter to the listView
		        mDrawerList.setAdapter(mAdapter);  
	}
	private void getMenuOption() {
		// TODO Auto-generated method stub
	String[] tempVal=getResources().getStringArray(R.array.Menuoption);
	MenuOption =new MenuString[tempVal.length];
	for (int i=0;i<tempVal.length;i++)
	{
		MenuOption[i]=new MenuString();
		MenuOption[i].setDisplayName(tempVal[i]);
		MenuOption[i].setName(tempVal[i].replace(" ", "_"));
		if(tempVal[i].equals(getString(R.string.MenuT_Entry)) || tempVal[i].equals(getString(R.string.MenuT_Reports)))
		{
			MenuOption[i].setCharctor(1);
		}
		else
		{
			MenuOption[i].setCharctor(2);
		}
	}
	}
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
	          return true;
	    }
		return super.onOptionsItemSelected(item);
	}	
			
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	public void showFragment(int position){
		// Creating a Bundle object
        Bundle data = new Bundle();
        // Setting the index of the currently selected item of mDrawerList
        data.putInt("position", position);// Getting reference to the FragmentManager
        FragmentManager fragmentManager  = getSupportFragmentManager();

        // Creating a fragment transaction
        FragmentTransaction ft = fragmentManager.beginTransaction();

        mTitle = MenuOption[position].getDisplayName();	
        if(position==1 || position==2)
        {
        	AddItem cFragment = new AddItem();
            // Setting the position to the fragment
            cFragment.setArguments(data);
            // Adding a fragment to the fragment transaction
            ft.replace(R.id.content_frame, cFragment);
        }
        else{
        // Creating a fragment object
        MainScreen cFragment = new MainScreen();
        // Setting the position to the fragment
        cFragment.setArguments(data);

        
        // Adding a fragment to the fragment transaction
        ft.replace(R.id.content_frame, cFragment);
        }
        



        // Committing the transaction
        ft.commit();
	}
	public void highlightSelectedCountry(){
		
    	    	if(mPosition!=-1)
    		getSupportActionBar().setTitle( MenuOption[mPosition].getDisplayName());
	}	

}
