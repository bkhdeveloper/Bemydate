package com.example.hamdisoap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Act_Login extends Activity {

	private TextView _mTvResult;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_login);
		
		_mTvResult=(TextView) findViewById(R.id.ALogin_TvCodeID);
		
	}

	public void onClickValidate(View v){

		finish();
		startActivity(new Intent(this,Act_SingleFinder.class));
	}

	public void onClickCreateAccount(View v){
		startActivityForResult(new Intent(this,Act_Account.class),1000);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode==1000 && resultCode==RESULT_OK){
			
			float lResult=data.getExtras().getFloat("MyResul");
			_mTvResult.setText((""+lResult).replace(".0", ""));
		}
	}
}
