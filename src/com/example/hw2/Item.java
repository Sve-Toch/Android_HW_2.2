package com.example.hw2;

import android.graphics.Bitmap;


public class Item {
	     private Bitmap IconFile;
	     private String Name;

	    public Item( Bitmap iconFile, String name) {
	    	IconFile = iconFile;
	        Name = name;
	    }
	    public Bitmap getIcon()
	    {
	    	return IconFile;
	    }
	    public String getName()
	    {
	    	return Name;
	    }
}
