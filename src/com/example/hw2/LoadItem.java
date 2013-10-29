package com.example.hw2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class LoadItem {
	private final static String TAG = "LoadItem";
	private final static String iUrl = "http://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png";
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
	    try {
	        URL url = new URL(src);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setDoInput(true);
	        connection.connect();
	        InputStream input = connection.getInputStream();
	        Bitmap myBitmap = BitmapFactory.decodeStream(input);
	        return myBitmap;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	 
	  public static Bitmap downloadImage(String iUrl) {
	    Bitmap bitmap = null;
	    HttpURLConnection conn = null;
	    BufferedInputStream buf_stream = null;
	    try {
	      Log.v(TAG, "Starting loading image by URL: " + iUrl);
	      conn = (HttpURLConnection) new URL(iUrl).openConnection();
	      conn.setDoInput(true);
	      conn.setRequestProperty("Connection", "Keep-Alive");
	      conn.connect();
	      buf_stream = new BufferedInputStream(conn.getInputStream(), 8192);
	      bitmap = BitmapFactory.decodeStream(buf_stream);
	      buf_stream.close();
	      conn.disconnect();
	      buf_stream = null;
	      conn = null;
	    } catch (MalformedURLException ex) {
	      Log.e(TAG, "Url parsing was failed: " + iUrl);
	    } catch (IOException ex) {
	      Log.d(TAG, iUrl + " does not exists");
	    } catch (OutOfMemoryError e) {
	      Log.w(TAG, "Out of memory!!!");
	      return null;
	    } finally {
	      if ( buf_stream != null )
	        try { buf_stream.close(); } catch (IOException ex) {}
	      if ( conn != null )
	        conn.disconnect();
	    }
	    return bitmap;
	  }
	
	
}
