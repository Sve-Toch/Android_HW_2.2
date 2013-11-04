package com.example.hw2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.R.anim;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.util.Log;

public class LoadItem  {
	private final static String TAG = "LoadItem";
	private final static String iUrl = "http://mpandroid.filin.mail.ru/pic?email=example@mail.ru&width=90&height=90&name=";
	public static ArrayList<Item>loaditem(MainList mainList, String name){
	ArrayList<Item>	 item = new ArrayList<Item>();
		  Log.v(TAG, " new ArrayList");
		  Integer position=0;
		  Bitmap im= BitmapFactory.decodeResource(mainList.getResources(), R.drawable.ic_launcher);
		  for ( position=0; position<name.length();position++)
		    {
		  item.add(new Item(im,position.toString()+" буква "+name.charAt(position)));
		    }
		   
		    for ( position=0; position<name.length();position++)
		    {
		    	AsyncLoadItem al =new AsyncLoadItem(mainList,position); 	
		    	al.execute(iUrl+name.charAt(position)+'/') ;   
		    }
    
      
     return item;
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
