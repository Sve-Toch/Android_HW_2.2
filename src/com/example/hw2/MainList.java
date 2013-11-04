package com.example.hw2;

import java.util.ArrayList;
import java.util.List;

import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class MainList extends ListFragment{
	private MyArrayAdapter adapter;
	private ArrayList<Item> item;


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		String name= FrActivity.gettext();
		item=LoadItem.loaditem(this,name);
 	    int resID= R.layout.list_row;
	    adapter   = new MyArrayAdapter(getActivity(),resID, item);
		setListAdapter(adapter);
	
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		//Toast.makeText(getActivity(), "dsmfsldj="+position, Toast.LENGTH_LONG).show();
		FragmentDetail detail= (FragmentDetail) getFragmentManager().findFragmentById(R.id.fragment_detail);
		Intent i  =new Intent(getActivity().getApplicationContext(),FragmentDitailActivity.class);
		adapter=(MyArrayAdapter) getListAdapter();
		List<Item> items = adapter.items;
		Item item2=items.get(position);
		Bitmap icon=item2.getIcon();
		i.putExtra("icon", icon);
		startActivity(i);
		
	}
	
}
