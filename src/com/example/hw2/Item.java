package com.example.hw2;


public class Item {
	     private int IconFile;
	     private String Name;

	    public Item( int iconFile, String name) {
	    	IconFile = iconFile;
	        Name = name;
	    }
	    public int getIcon()
	    {
	    	return IconFile;
	    }
	    public String getName()
	    {
	    	return Name;
	    }
}
