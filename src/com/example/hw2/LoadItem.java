package com.example.hw2;

import java.util.ArrayList;

public class LoadItem {
	public static ArrayList<Item>loaditem(){
		ArrayList<Item>	 item = new ArrayList<Item>();
     item.add(new Item(R.drawable.ic_launcher," name"));
     item.add(new Item(R.drawable.ic_launcher," name"));
     item.add(new Item(R.drawable.ic_launcher," name"));
     item.add(new Item(R.drawable.ic_launcher," name"));
     item.add(new Item(R.drawable.ic_launcher," name"));    
     return item;
	}
}
