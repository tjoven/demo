package com.tjoven.volley;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class StringRequestDemo extends BaseActivity{
	@ViewInject(R.id.button1)
	private Button stringBt;
	@ViewInject(R.id.button2)
	private Button jsonBt;
	
	RequestQueue queue;
	
	String TAG=StringRequestDemo.class.getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.http_request);
		ViewUtils.inject(this);
		
		stringBt.setText("发送String网络请求");
		jsonBt.setText("发送json网络请求");
		
		//创建对象
		queue=Volley.newRequestQueue(this);
		stringBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stringRequest();
				
			}
		});
		jsonBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				JsonRequest();
				
			}
		});
	}
	
	private void JsonRequest() {
		//发送请求
				String url="http://www.baidu.com";
				JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(url, null, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						Log.i(TAG, response.toString());
						
					}
					
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e(TAG, error.getMessage());
						
					}
				}
		);
				queue.add(jsonObjectRequest);
	}
	private void stringRequest() {
		//发送请求
		String url="http://www.baidu.com";
		Listener<String> listener=new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Log.i(TAG, response);
				
			}
			
		};
		ErrorListener errorListener=new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.i(TAG, error.getMessage());
				
			}
		};
		StringRequest request=new StringRequest(Method.GET,url, listener, errorListener);
		//将请求添加到RequestQueen中
		if (request!=null) {
			queue.add(request); 
		}
		
		StringRequest request2=new StringRequest(Method.POST, url, listener, errorListener){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				HashMap<String , String > map=new HashMap<String, String>();
				map.put("params1", "values1");
				return map;
			}
		};
//		queue.add(request2);
		
		
	}
}
