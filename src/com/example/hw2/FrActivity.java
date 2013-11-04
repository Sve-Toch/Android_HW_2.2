package com.example.hw2;


import android.app.Activity;
import android.os.Bundle;

public class FrActivity extends Activity{
static String text;
public static String gettext()
{return text;}
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.fragmentactivity);
	text =getIntent().getStringExtra("text");
	  
}
}
