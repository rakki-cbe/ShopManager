/**
 * @author Radhakrishnan S
 * Created Date :24-Sep-2014
 * Purpose :Login User 
 * 
 */
package com.SRMTechnology.inventorymanager;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.SRMTechnology.inventorymanager.dialogs.InformationDialog;
import com.SRMTechnology.inventorymanager.dialogs.ProgressDialogBox;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class Login extends Activity {
EditText EDUserName,EDPassword;
TextView TVForgot;
ProgressDialogBox PD;
InformationDialog ID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		if(ParseUser.getCurrentUser()!=null)
		{
			Intent in = new Intent(this,HomeScreen.class);
			startActivity(in);
		}
		EDUserName=(EditText) findViewById(R.id.Login_username);
		EDPassword=(EditText)findViewById(R.id.Login_password);
		TVForgot=(TextView) findViewById(R.id.Login_Forgot);
		 PD=new ProgressDialogBox(this);
		 ID=new InformationDialog(this);
	}
	  public void clicker(View v)
	    {
	    	switch (v.getId()) {
			case R.id.Login_Cancel:
				Intent in = new Intent(this,LauncherActivity.class);
				in.putExtra("Close", true);
				startActivity(in);
				break;
			case R.id.Login_Login:
				boolean erro=false;
				if(EDUserName.getText().toString().trim().equals(""))
				{
					EDUserName.setError(getString(R.string.Register_PasswordError));
					erro=true;
				}
				if(EDPassword.getText().toString().trim().equals(""))
				{
					erro=true;
					EDPassword.setError(getString(R.string.Register_PasswordError));
				}
				/***Parse User Registration */
				if(!erro)
				{
					new LoginTask().execute(1);
				}
				/***Parse User Registration*/
			break;
			case R.id.Login_Create:
				Intent in1 = new Intent(this,CreateAccount.class);
				startActivity(in1);
			break;
			case R.id.Login_Forgot:
				//ForgotPassword().execute(1);
			break;
			default:
				break;
			}
	    }
	  class LoginTask extends AsyncTask<Integer, Integer, String>
	    {
	    	
			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				PD.showProgressDialogBox(null, getString(R.string.Progress_waitLogin));
				
			}

			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				
			}

			@Override
			protected String doInBackground(Integer... params) {
				// TODO Auto-generated method stub
				ParseUser.logInInBackground(EDUserName.getText().toString().toLowerCase(), EDPassword.getText().toString().toLowerCase(), new LogInCallback() {
					@Override
					public void done(ParseUser arg0, ParseException arg1) {
						// TODO Auto-generated method stub
						if(arg1!=null)
						{
							PD.CancelDialog();
							ID.showInformation("Sorry", "We can't login you <br>"+arg1.getMessage());
						}
						else
						{
							PD.CancelDialog();
							ID.showInformation("Success", "Logged In");
						}
					}
				});
				
				return null;
			}
	    }
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent in = new Intent(this,LauncherActivity.class);
		in.putExtra("close", true);
		startActivity(in);
	}
	
}
