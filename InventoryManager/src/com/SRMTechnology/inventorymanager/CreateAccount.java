package com.SRMTechnology.inventorymanager;

import com.SRMTechnology.inventorymanager.Common.Function;
import com.SRMTechnology.inventorymanager.dialogs.InformationDialog;
import com.SRMTechnology.inventorymanager.dialogs.ProgressDialogBox;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.internal.AsyncCallback;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class CreateAccount extends Activity {
EditText EDUserName,EDPassword,EDEmail;
ProgressDialogBox PD;
InformationDialog ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        EDUserName = (EditText) findViewById(R.id.Register_username);
        EDPassword = (EditText) findViewById(R.id.Register_password);
        EDEmail = (EditText) findViewById(R.id.Register_email);
        PD=new ProgressDialogBox(this);
        ID=new InformationDialog(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void clicker(View v)
    {
    	switch (v.getId()) {
		case R.id.Register_Cancel:
			Intent in =new Intent(CreateAccount.this,Login.class);
	    	startActivity(in);
			break;
		case R.id.Register_Register:
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
			if(EDEmail.getText().toString().trim().equals("") && Function.EmailValid(EDEmail.getText().toString().trim()))
			{
				erro=true;
				EDEmail.setError(getString(R.string.Register_EmailError));
			}
			/***Parse User Registration */
			if(!erro)
			{
				new Registration().execute(1);
			}
			/***Parse User Registration*/
		break;
		default:
			break;
		}
    }
    class Registration extends AsyncTask<Integer, Integer, String>
    {
    	
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			PD.showProgressDialogBox(null, getString(R.string.Progress_waitRegister));
			
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
		}

		@Override
		protected String doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			ParseUser user = new ParseUser();
			user.setUsername(EDUserName.getText().toString().toLowerCase());
			user.setPassword(EDPassword.getText().toString().toLowerCase());
			user.setEmail(EDEmail.getText().toString().toLowerCase());
			 
			// other fields can be set just like with ParseObject
			 
			user.signUpInBackground(new SignUpCallback() {
			  public void done(ParseException e) {
			    if (e == null) {
			      // Hooray! Let them use the app now.
			    	PD.CancelDialog();
			    	Function.showToast("Account Created Successfully", Toast.LENGTH_LONG, CreateAccount.this);
			    	Intent in =new Intent(CreateAccount.this,Login.class);
			    	startActivity(in);
			    			
			    } else {
			    	PD.CancelDialog();
			    	ID.showInformation("Sorry", "You account not created <br>"+e.getLocalizedMessage());
			    	/*Toast t=Toast.makeText(CreateAccount.this, "Error on registration "+e.getMessage(), Toast.LENGTH_LONG);
	    			t.show();*/
			      // Sign up didn't succeed. Look at the ParseException
			      // to figure out what went wrong
			    }
			  }
			});
			return null;
		}
    }
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		finish();
		Intent in =new Intent(CreateAccount.this,Login.class);
    	startActivity(in);
    	//super.onBackPressed();
	}
    
}
