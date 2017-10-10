package com.tjoven.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class NetWorkLoader extends AsyncTaskLoader<String>{

	private String result = null;
	public NetWorkLoader(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onStartLoading() {
		// TODO Auto-generated method stub
		super.onStartLoading();
		if (result==null) {
			//自动调用loadInBackground
			forceLoad();
		}else {
			//自动调用LoaderCallbacks.onLoadFinished
			deliverResult(result); 
		}
	}
	@Override
	protected void onStopLoading() {
		// TODO Auto-generated method stub
		super.onStopLoading();
	}
	@Override
	public String loadInBackground() {
		// TODO Auto-generated method stub
		String url = "http://gc.ditu.aliyun.com/geocoding?a=苏州市";  
        return doGet(url); 
	}
	
	
	private String doGet(String url) {  
        BufferedReader in = null;  
        try {  
            HttpClient client = new DefaultHttpClient();  
            HttpGet request = new HttpGet(url);  
            HttpResponse response = client.execute(request);  
            in = new BufferedReader(new InputStreamReader(response.getEntity()  
                    .getContent()));  
  
            StringBuffer sb = new StringBuffer("");  
            String line = "";  
            String NL = System.getProperty("line.separator");  
            while ((line = in.readLine()) != null) {  
                sb.append(line + NL);  
            }  
            in.close();  
  
            String page = sb.toString();  
              
            return page;  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (in != null) {  
                try {  
                    in.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return url;  
    } 

}
