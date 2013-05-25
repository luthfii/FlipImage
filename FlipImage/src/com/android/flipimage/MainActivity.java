package com.android.flipimage;



import java.io.FileNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Intent;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.flipimage.R;
import com.android.flipimage.lib.FlipViewController;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
//import android.widget.ImageView;
//import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	Button buttonLoadImage;
	TextView textTargetUri;
	ImageView targetImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		buttonLoadImage = (Button) findViewById(R.id.buttonLoadImage);
		buttonLoadImage.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent( Intent.ACTION_PICK, 
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent, 0);
			}
		});
		//	ImageView image = (ImageView) findViewById(R.id.imageView1);
		//image.setImageResource(R.drawable)
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK) {
			Uri targetUri = data.getData();
			textTargetUri.setText(targetUri.toString());
			Bitmap bitmap;
			try {
				bitmap = BitmapFactory.decodeStream(getContentResolver()
						.openInputStream(targetUri));
				targetImage.setImageBitmap(bitmap);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void horizontal(View view){
		Intent intent = new Intent(this, FlipHorizontalLayoutActivity.class);
		startActivity(intent);
	}

}
