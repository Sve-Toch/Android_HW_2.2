package com.example.hw2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class FragmentDitailActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_detail_activity);
		ImageView iv=(ImageView) findViewById(R.id.fragment_detail_iv);
		Bundle extras=getIntent().getExtras();
		Bitmap icon =(Bitmap) extras.get("icon");
		iv.setImageBitmap(icon);
		
		
	}

}
