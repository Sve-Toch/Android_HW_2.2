package com.example.hw2;


import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

public class AsyncLoadItem  extends AsyncTask<String,Integer,Bitmap>{
	private final static String TAG = "AsyncLoadItem";
	private Activity mainActivity;
	private int position;
	
	public AsyncLoadItem (Activity mainActivity,int position)
	{
		this.mainActivity=mainActivity;
		this.position=position;
	}
	@Override
	protected void onProgressUpdate(Integer... progres)
	{
		 
	}
	@Override
    protected void onPreExecute() {
		Log.v(TAG, "onPreExecute");
		}
	@Override
	protected void onPostExecute(Bitmap result) {
		Log.v(TAG, "onPostExecute");	
		  ListView   listView = null;//(ListView) mainActivity.findViewById(R.id.lvMain);
		  MyArrayAdapter adapter  = (MyArrayAdapter) listView.getAdapter();
		  ArrayList<Item> items =(ArrayList<Item>) adapter.getItem();
		  Item item=items.get(position);	
		  items.set(position, new Item(result,item.getName()));	     
		  adapter.notifyDataSetChanged();
	      adapter.notifyDataSetInvalidated();
		}
	@Override
	protected Bitmap doInBackground(String... params) {
		// TODO Auto-generated method stub
		Log.v(TAG, "doInBackground");
		return getBitmapFromURL(params[0]);
	}
	public static Bitmap getBitmapFromURL(String src) {
		HttpURLConnection connection = null;
		Bitmap myBitmap =null;
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
		try {
		//	HttpURLConnection.setFollowRedirects(false);
			Log.v(TAG, "Starting loading image by URL: " + src);
	        URL url = new URL(src);
	        connection = (HttpURLConnection) url.openConnection();
	 
	  	    connection.setRequestMethod("GET");
	  	 connection.setRequestProperty("Accept", "text/plain");
         //  connection.setDoInput(true);
	       connection.connect();  
	    
	       int responseCode = connection.getResponseCode();
	       Log.v(TAG, "connection"+responseCode);
	        if  (responseCode==HttpURLConnection.HTTP_OK)
	        {
	            Log.v(TAG, "Good connection");
	        	InputStream input = connection.getInputStream();
	        	BufferedInputStream buf_stream = new BufferedInputStream(input, 8192);
	        	myBitmap = BitmapFactory.decodeStream(buf_stream);
	  	        buf_stream.close();
	  	       connection.disconnect();
	  	       input.close();
	        }
	        else  return null;
	       
		    } catch (Exception e) {
		        e.printStackTrace();
		        Log.v(TAG, "ERROR");
		    }
		//finally {
		//     if (connection != null) {
		//    connection.disconnect();
		//    Log.v(TAG, "Disconnect");
		//    return null;
		//   }
		//}
		return myBitmap;
	}	 

}

	
	
	
	 

