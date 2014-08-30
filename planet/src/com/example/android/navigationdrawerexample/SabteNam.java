package com.example.android.navigationdrawerexample;

import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;



import android.app.Activity;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SabteNam extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sabte_nam);
		getActionBar().setTitle(R.string.title_sabteNam);

		Button save = (Button) findViewById(R.id.btnSave);

		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				TextView tname = (TextView) findViewById(R.id.txtTeamName);
				TextView uname = (TextView) findViewById(R.id.txtUserName);
				TextView pnumber = (TextView) findViewById(R.id.txtPhone);
				
				JSONObject json = new JSONObject();
				try {
					json.put("teamName", tname.getText().toString());
					json.put("userName", uname.getText().toString());
					json.put("phoneNumber", pnumber.getText().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				Httpres hooman = new Httpres(SabteNam.this,"http://192.168.56.1:5000/mytesturl",json.toString());///////////////////////////////////////
			//	hooman.tnam = tname.getText().toString();
			//	hooman.unam = uname.getText().toString();
			//	hooman.pnum = pnumber.getText().toString();
				hooman.execute();
				try {
					String tmp = hooman.get(); ///////////////////////////in nemidunam chie :( ////////////////////////
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();} 
				catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();}
			}
		});

	}

}
