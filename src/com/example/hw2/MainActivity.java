package com.example.hw2;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;


public class MainActivity extends Activity {
	 ListView listView;
	private ArrayList<Item> item;
	private MyArrayAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);
	     ListView   listView = (ListView) findViewById(R.id.lvMain);
	    
	        item=LoadItem.loaditem();
	     int resID= R.layout.list_row;
	     // создаем адаптер
	     adapter   = new MyArrayAdapter(this,
	    		 resID, item);
	     listView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

}
