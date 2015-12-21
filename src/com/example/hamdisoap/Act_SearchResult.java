package com.example.hamdisoap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Act_SearchResult extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_search_result);
		
		String lExtratContent="";
		Bundle lBundle=getIntent().getExtras();
		if(lBundle!=null)
			lExtratContent=lBundle.getString("ExratSelection");
		
		TextView lTv=(TextView) findViewById(R.id.ASResult_TvResult);
		lTv.setText(lExtratContent);

	}
}
