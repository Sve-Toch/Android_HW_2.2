package com.example.hw2;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<Item> {
int resource;
public MyArrayAdapter(Context context,
		int _resource,
		List<Item> items) {
	super(context, _resource, items);
	resource = _resource;
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
LinearLayout newView;

Item classInstance = getItem(position);
int icon = classInstance.getIcon();
String name = classInstance.getName();
// TODO Извлечь из переменной classInstance
// данные для отображения.
// Inflate a new view if this is not an update.
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
iv.setImageResource(icon);
TextView tv = (TextView) newView.findViewById(R.id.textView);
tv.setText(name);
// TODO Извлчь Представления для наполнения их данными.
// TODO Наполнить Представления свойствами из полученного объекта.
return newView;
}
}