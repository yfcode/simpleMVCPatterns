package com.example.mvcpatterns;

import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements Observer, OnClickListener{
	
	private Model mModel;
	private Button mButton1;
	private Button mButton2;	
	private Button mButton3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mModel = new Model();
		mModel.addObserver(this);//add the activity as the observer
		
		mButton1 = (Button)findViewById(R.id.button1);
		mButton2 = (Button)findViewById(R.id.button2);
		mButton3 = (Button)findViewById(R.id.button3);
		
		mButton1.setOnClickListener(this);
		mButton2.setOnClickListener(this);
		mButton3.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.button1:
			mModel.setValueAtIndex(0);
			break;
		case R.id.button2:
			mModel.setValueAtIndex(1);
			break;
		case R.id.button3:
			mModel.setValueAtIndex(2);
			break;
		}
		
	}

	@Override
	public void update(Observable observable, Object data) {
		mButton1.setText("count: "+ mModel.getValueAtIndex(0));
		mButton2.setText("count: "+ mModel.getValueAtIndex(1));
		mButton3.setText("count: "+ mModel.getValueAtIndex(2));
		
	}

}
