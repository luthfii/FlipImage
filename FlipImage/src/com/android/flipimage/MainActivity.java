package com.android.flipimage;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

import com.android.flipimage.R;

import com.android.flipimage.R;
import com.android.lib.*;


public class MainActivity extends Activity {
	
	private FlipViewController flipView;
	
	/**BEGIN Memo**/
	/* The connection to the hardware */
	private ShakeDetector myShakeDetector;
    private SensorManager mySensorManager;
    private Sensor myAccelerometer;
	/**END Memo**/

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		setTitle(R.string.activity_title);

		flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);

		flipView.setAdapter(new TravelAdapter(this));

		setContentView(flipView);
		
		/**Begin Memo**/
		mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE); // (1)
		myAccelerometer = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        myShakeDetector = new ShakeDetector();
        
        
		//mSensorListener.setOnShakeListener(new ShakeEventListener.OnShakeListener() {
        myShakeDetector.setShakeDetector(new ShakeDetector.OnShakeListener() {
			
			@Override
			public void onShake() {
				Toast.makeText(MainActivity.this, "Shake!", Toast.LENGTH_SHORT).show();
			}
		
		});


	}

	
	/**BEGIN Memo**/
	@Override
	protected void onResume() {
		super.onResume();
		flipView.onResume();
        mySensorManager.registerListener(myShakeDetector, myAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		super.onPause();
		flipView.onPause();
		mySensorManager.unregisterListener(myShakeDetector);
	}
	/**END Memo**/

}