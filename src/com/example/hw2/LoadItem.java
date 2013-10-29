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

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class LoadItem {
	private final static String TAG = "LoadItem";
	private final static String iUrl = "http://www.android.com/";
	public static ArrayList<Item>loaditem(){
		ArrayList<Item>	 item = new ArrayList<Item>();
		  Log.v(TAG, " new ArrayList");
   // Bitmap im =downloadImage(iUrl);
    Bitmap im =getBitmapFromURL(iUrl) ;
    
   
    item.add(new Item(im," name"));
    item.add(new Item(im," name"));
    item.add(new Item(im," name"));
    item.add(new Item(im," name"));
    item.add(new Item(im," name"));    
     return item;
	}
	
	

	public static Bitmap getBitmapFromURL(String src) {
		HttpURLConnection connection = null;
		Bitmap myBitmap =null;
		try {
		//	HttpURLConnection.setFollowRedirects(false);
			Log.v(TAG, "Starting loading image by URL: " + iUrl);
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
	        	return myBitmap;
	        }
	        else  return null;
	       
		    } catch (IOException e) {
		        e.printStackTrace();
		        Log.v(TAG, "ERROR");
		        return null;
		    }
		finally {
		    if (connection != null) {
		    connection.disconnect();
		    Log.v(TAG, "Disconnect");
		    return null;
		   }
	}
	
	}	 
	
	
	
	
	
	
	
}
