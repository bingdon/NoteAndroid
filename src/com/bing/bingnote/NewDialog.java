package com.bing.bingnote;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class NewDialog extends Activity {

	private RadioGroup mGroup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newbing);
		
		mGroup=(RadioGroup)findViewById(R.id.radioGroup1);
		mGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
			
				Log.i("Ñ¡Ôñ", "×éÊý:"+checkedId);
				
			}
		});
	}
	
	
}
