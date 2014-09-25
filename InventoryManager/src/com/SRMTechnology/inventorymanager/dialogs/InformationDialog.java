/**
 * @author Radhakrishnan S
 * Created Date :24-Sep-2014
 * Purpose : Show the information to the users
 * 
 */
package com.SRMTechnology.inventorymanager.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.SRMTechnology.inventorymanager.CreateAccount;

public class InformationDialog {
Context context;
private  AlertDialog AD; 
	public InformationDialog(Context context) {
		// TODO Auto-generated constructor stub
		this.context=context;
	}
	public void showInformation(String Title,String Msg)
	{
		if(AD!=null)
		{
			AD.dismiss();
			AD=null;
		}
 AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
	     
		 alertDialogBuilder.setTitle(Title);
		 alertDialogBuilder.setMessage(Msg);
		 
		 // set neutral button: Exit the app message
		 alertDialogBuilder.setNeutralButton("OK",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// exit the app and go to the HOME
					AD.dismiss();
				}
			});
		 
		 AD = alertDialogBuilder.create();
		 // show alert
		 AD.show();
	}
	public void Dismiss()
	{
		AD.dismiss();
		AD=null;
	}

}
