package com.SRMTechnology.inventorymanager.Common;

import com.SRMTechnology.inventorymanager.CreateAccount;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class Function {

	public static boolean EmailValid(String trim) {
		// TODO Auto-generated method stub
		
		return true;
	}
public static void showToast(String Msg,int Duration,Context con)
{
	Toast t=Toast.makeText(con, Msg, Duration);
	t.show();
}
}
