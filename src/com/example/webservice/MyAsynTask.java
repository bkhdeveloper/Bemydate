package com.example.webservice;

import com.example.hamdisoap.R;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class MyAsynTask extends AsyncTask<Void, Integer, String>{

	
	private ProgressDialog _mProgress;
	private Context _mContext;
	
public MyAsynTask(Context pContext){
	_mContext=pContext;
}
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		
		_mProgress=new ProgressDialog(_mContext);
		_mProgress.setTitle(R.string.lab_synchor_runing);
		_mProgress.show();
	}
	@Override
	protected String doInBackground(Void... params) {
		return null;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if(_mProgress.isShowing())
			_mProgress.dismiss();
	}

}
