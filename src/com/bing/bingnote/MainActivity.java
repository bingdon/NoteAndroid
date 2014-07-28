package com.bing.bingnote;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		ActionBar mActionBar=getSupportActionBar();
		mActionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.pb1));
		
		
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private Button mButton;
		private SensorManager sensorManager;
		private Vibrator vibrator;
		private long [] bing=new long[4];
		private EditText editText;
		
		public PlaceholderFragment() {
			bing[0]=100;
			bing[1]=300;
			bing[2]=100;
			bing[3]=300;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);

			mButton = (Button) getActivity().findViewById(R.id.button1);
			mButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					new Thread(bingRunnable).start();
					Toast.makeText(getActivity(), "随机数:"+Math.random(), 1000*10).show();
					// Intent intent=new Intent();
					// intent.setClass(getActivity(), NewDialog.class);
					// startActivity(intent);
				}
			});

			editText=(EditText)getActivity().findViewById(R.id.bingEditText1);
			
//			sensorManager = (SensorManager) getActivity().getSystemService(
//					SENSOR_SERVICE);
//			vibrator = (Vibrator) getActivity().getSystemService(
//					VIBRATOR_SERVICE);
//
//			sensorManager.registerListener(bingEventListener,
//					sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
//					SensorManager.SENSOR_DELAY_NORMAL);

		}

		@Override
		public void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
			if (sensorManager != null) {
				sensorManager.unregisterListener(bingEventListener);
			}
		}

		private SensorEventListener bingEventListener = new SensorEventListener() {

			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				float values[] = event.values;
				float x = Math.abs(values[0]);
				float y = Math.abs(values[1]);
				float z = Math.abs(values[2]);
				float max = Math.max(x, y);
				max = Math.max(max, z);
			
				if (max > 18) {
//					vibrator.vibrate(500);
					Toast.makeText(getActivity(), "随机数:"+Math.random(), 1000*10).show();
					vibrator.vibrate(bing, -1);
				}
				Log.i(TAG, "晃动:" + max);
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub

			}
		};

		public Runnable bingRunnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
//				Instrumentation inst = new Instrumentation();
//				inst.sendStringSync("bing" + "key");
//				Intent intent=new Intent();
//				intent.setClass(getActivity(), NewDialog.class);
//				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				inst.startActivitySync(intent);

			}
		};

	}

//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		// TODO Auto-generated method stub
//		if(keyCode != KeyEvent.KEYCODE_BACK) {
//			Log.i(TAG, "按键:"+event.getAction()+"==键值 ==="+keyCode);
//			return true;
//		}else{
//			return super.onKeyDown(keyCode, event);
//		}
//		
//	}
	
	
}
