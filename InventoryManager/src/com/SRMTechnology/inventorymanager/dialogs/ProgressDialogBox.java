package com.SRMTechnology.inventorymanager.dialogs;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogBox {
Context context;
ProgressDialog PD;
	public ProgressDialogBox(Context con) {
		this.context=con;
	}
	public boolean showProgressDialogBox(String title,String Message)
	{
		try
		{
		if(PD!=null)
		{
			PD.dismiss();
			PD=null;
		}
		PD= new ProgressDialog(context);
		if(Message!=null)
			PD.setMessage(Message);
		if(title!=null)
			PD.setTitle(title);
        PD.show();
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public void CancelDialog()
	{
		if(PD!=null)
		{
			PD.dismiss();
			PD=null;
		}
	}

}
