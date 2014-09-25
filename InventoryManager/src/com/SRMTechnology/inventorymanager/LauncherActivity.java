/**
 * @author Radhakrishnan S
 * Created Date :24-Sep-2014
 * Purpose : Launching and give advertisement for company
 * 
 */
package com.SRMTechnology.inventorymanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LauncherActivity extends Activity {
	Handler myHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		Bundle b=getIntent().getExtras();
		if(b!=null)
		{
			if(b.get("close")!=null)
			{
				if(b.getBoolean("close"))
				{
					Intent startMain = new Intent(Intent.ACTION_MAIN);
					startMain.addCategory(Intent.CATEGORY_HOME);
					startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(startMain);
				}
			}
		}
		Runnable runnable = new Runnable() {
			public void run() {     	

				Intent in = new Intent(LauncherActivity.this,Login.class);
				startActivity(in);
			}
		};
		myHandler=new Handler();
		myHandler.postDelayed(runnable, 10000);



	}



}
