package com.example.hw2;

import java.util.ArrayList;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity {
	 ListView listView;
	 EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.activity_main);
	     editText=(EditText) findViewById(R.id.editText1);
	    Button button1 = (Button) findViewById(R.id.button1);
	    button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	    
	    	  if (!editText.getText().toString().equals("")){
	    			Intent i = new Intent(MainActivity.this, FrActivity.class);
					i.putExtra("text",editText.getText().toString());
					startActivity(i);
	    	  }
			}
	   

	});
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

}
