package com.example.hw2;

import java.util.ArrayList;

import android.app.ListFragment;
import android.os.Bundle;


public class MainList extends ListFragment{
	private MyArrayAdapter adapter;
	private ArrayList<Item> item;


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		item=LoadItem.loaditem(getActivity(),"sveta");
 	    int resID= R.layout.list_row;
	    adapter   = new MyArrayAdapter(getActivity(),resID, item);
		setListAdapter(adapter);
	}
	
}
