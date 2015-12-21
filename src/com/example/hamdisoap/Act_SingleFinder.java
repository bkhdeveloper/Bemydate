package com.example.hamdisoap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Act_SingleFinder extends Activity implements OnClickListener {

	private TextView _mTVIamMan;
	private TextView _mTVIamWomen;
	private TextView _mTVILook4Man;
	private TextView _mTVILook4Women;
	
	private String _mSelectionIam;
	private String _mSelectionLooking4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_single_finder);
		initView();
	}

	private void initView() {

		_mTVIamMan=(TextView) findViewById(R.id.ASFinder_TVSexMan);
		_mTVIamMan.setOnClickListener(this);

		_mTVIamWomen=(TextView) findViewById(R.id.ASFinder_TVSexWomen);
		_mTVIamWomen.setOnClickListener(this);

		_mTVILook4Man=(TextView) findViewById(R.id.ASFinder_TVSexManLook4);
		_mTVILook4Man.setOnClickListener(this);

		_mTVILook4Women=(TextView) findViewById(R.id.ASFinder_TVSexWomanLook4);
		_mTVILook4Women.setOnClickListener(this);
		
		_mSelectionIam=getResources().getString(R.string.lab_sex_man);
		_mSelectionLooking4=getResources().getString(R.string.lab_sex_women);
	}

	public void onClickSearch(View v) {
		
		// I am a man loking for a women
		String lSelection=getResources().getString(R.string.lab_Iam)+" "+
		_mSelectionIam+" "+getResources().getString(R.string.lab_Look4)+" "+_mSelectionLooking4;
		
		Intent lIntent=new Intent(this,Act_SearchResult.class);
		lIntent.putExtra("ExratSelection", lSelection);
		startActivity(lIntent);
	}

	@Override
	public void onClick(View v) {
		
		
		if(v instanceof TextView){
			((TextView)v).setTextColor(Color.WHITE);
			v.setBackgroundColor(getResources().getColor(R.color.colorTheme));
		}

		switch (v.getId()) {
		case R.id.ASFinder_TVSexMan:
			_mTVIamWomen.setTextColor(Color.GRAY);
			_mTVIamWomen.setBackgroundColor(Color.WHITE);
			_mSelectionIam=getResources().getString(R.string.lab_sex_man);
			break;
		case R.id.ASFinder_TVSexWomen:
			_mTVIamMan.setTextColor(Color.GRAY);
			_mTVIamMan.setBackgroundColor(Color.WHITE);
			_mSelectionIam=getResources().getString(R.string.lab_sex_women);
			break;
		case R.id.ASFinder_TVSexManLook4:		
			_mTVILook4Women.setTextColor(Color.GRAY);
			_mTVILook4Women.setBackgroundColor(Color.WHITE);
			_mSelectionLooking4=getResources().getString(R.string.lab_sex_man);
			break;
		case R.id.ASFinder_TVSexWomanLook4:
			_mTVILook4Man.setTextColor(Color.GRAY);
			_mTVILook4Man.setBackgroundColor(Color.WHITE);
			_mSelectionLooking4=getResources().getString(R.string.lab_sex_women);
			break;

		default:
			break;
		}

	}
}
