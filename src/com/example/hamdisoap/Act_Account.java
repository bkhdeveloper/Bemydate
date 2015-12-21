package com.example.hamdisoap;

import com.example.webservice.MyAsynTask;
import com.example.webservice.SoapManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Act_Account extends Activity implements OnCheckedChangeListener {

	public enum GENDER{MALE,FEMALE};
	private SoapManager _mSoapManager;
	private EditText _mEdNikName;
	private EditText _mEdEmail;
	private EditText _mEdPWD;
	private EditText _mEdContryZip;
	boolean lIsDataValid=true;
	private GENDER _mSelectedGender=GENDER.MALE;
	private float _mResultCode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_account);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		_mSoapManager=new SoapManager();
		
		_mEdNikName=(EditText) findViewById(R.id.AAccount_EdNikName);
		_mEdEmail=(EditText) findViewById(R.id.AAccount_EdEmail);
		_mEdPWD=(EditText) findViewById(R.id.AAccount_EdPassWord);
		_mEdContryZip=(EditText) findViewById(R.id.AAccount_EdCItyZIP);
		
		RadioGroup lRdg=(RadioGroup) findViewById(R.id.AAccount_RDG);
		lRdg.setOnCheckedChangeListener(this);

	}
	
	private boolean isDataValid(){
		
		
		if(_mEdNikName.getText().toString().isEmpty()){
			_mEdNikName.setError(getResources().getString(R.string.lab_error_emptyName));
			lIsDataValid=false;
		}else{
			
			new MyAsynTask(this){
				@Override
				protected String doInBackground(Void... params) {
					return ""+_mSoapManager.isNikNameAvailable(_mEdNikName.getText().toString());
				}
				protected void onPostExecute(String result) {
					super.onPostExecute(result);
					
					if(result.equals("false")){
						_mEdNikName.setError(getResources().getString(R.string.lab_error_ExistName));
						lIsDataValid=false;
					}
				};
			}.execute();
			
		}
		if(_mEdEmail.getText().toString().isEmpty()){
			_mEdEmail.setError(getResources().getString(R.string.lab_error_emptyEmail));
			lIsDataValid=false;
		}
		
		if(_mEdContryZip.getText().toString().isEmpty()){
			_mEdContryZip.setError(getResources().getString(R.string.lab_error_emptyCity));
			lIsDataValid=false;
		}
		
		if(_mEdPWD.getText().toString().isEmpty()){
			_mEdPWD.setError(getResources().getString(R.string.lab_error_emptyPassword));
			lIsDataValid=false;
		}
		
		
		
		
		return lIsDataValid;
	}

	public void onClickValidateNewAccount(View v){
		
		if(!isDataValid())
			return;
		
		
		new MyAsynTask(this){
			@Override
			protected String doInBackground(Void... params) {
				
				float lResult=_mSoapManager.registerUser(_mEdNikName.getText().toString(),_mEdEmail.getText().toString(), _mEdPWD.getText().toString(), _mSelectedGender);
				
				return ""+lResult;
			}
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				
				Toast.makeText(Act_Account.this, result, Toast.LENGTH_SHORT).show();
				
				_mResultCode=Float.parseFloat(result);
				
				if(_mResultCode!=-1){
					
					Intent lIntent=new Intent();
					lIntent.putExtra("MyResul", _mResultCode);
					setResult(RESULT_OK, lIntent);
					
					Act_Account.this.finish();
				}
			};
		}.execute();
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		switch (arg1) {
		case R.id.AAcount_RDSexMan:
			_mSelectedGender=GENDER.MALE;
			break;
		case R.id.AAcount_RDSexWomen:
			_mSelectedGender=GENDER.FEMALE;
			break;

		default:
			break;
		}
		
	}
}
