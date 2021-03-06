package com.example.hw2;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<Item> {
int resource;
List<Item>  items;
private final static String TAG = "MyArrayAdapter";
public MyArrayAdapter(Context context,
		int _resource,
		List<Item> items) {
	super(context, _resource, items);
	this.items=items;
	resource = _resource;
    Log.v(TAG, "New adapter");
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	Log.v(TAG, "get View");
LinearLayout newView;
Item classInstance = getItem(position);
Bitmap icon = classInstance.getIcon();
String name = classInstance.getName();

if (convertView == null) {
newView = new LinearLayout(getContext());
String inflater = Context.LAYOUT_INFLATER_SERVICE;
LayoutInflater vi = (LayoutInflater)getContext().
getSystemService(inflater);
vi.inflate(resource, newView, true);
} else {
newView = (LinearLayout)convertView;
}
ImageView iv = (ImageView) newView.findViewById(R.id.imageView);
iv.setImageBitmap(icon);
TextView tv = (TextView) newView.findViewById(R.id.textView);
tv.setText(name);

return newView;
}
public List<Item> getItem()
{return items;}
}