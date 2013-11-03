package com.example.hw2;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


public class MainActivity extends Activity {
	 ListView listView;
	private ArrayList<Item> item;
	private MyArrayAdapter adapter;
	private MainActivity a;
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
	    
	    	  ListView   listView = (ListView) findViewById(R.id.lvMain);
	    	  if (!editText.getText().toString().equals("")){
	 	     item=LoadItem.loaditem(MainActivity.this,editText.getText().toString());
	 	     int resID= R.layout.list_row;
	 	     // создаем адаптер
	 	     adapter   = new MyArrayAdapter(MainActivity.this,resID, item);
	 	     listView.setAdapter(adapter);
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
