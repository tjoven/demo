package com.tjoven.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

import android.R.integer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SocketClient extends BaseActivity {
	@ViewInject(R.id.TextView)
	private TextView textView;
	@ViewInject(R.id.EditText)
	private EditText editText;
	@ViewInject(R.id.Button)
	private Button button;
	
	private static final String IP="127.0.0.1";
	private static final int PORT = 9999; 
	private Socket socket = null;  
    private BufferedReader in = null;  
    private PrintWriter out = null;  
    private StringBuffer content = null;
    private String msg=null;
	
    private Handler handler=new Handler(){
    	public void handleMessage(android.os.Message msg) {
    		textView.setText(textView.getText().toString()+content);
    	}
    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three_view);
		ViewUtils.inject(this);
		button.setOnClickListener(this);
		msg=editText.getText().toString();
		bindSocket();
		
		//创建一个线程 由于就收服务器发送到消息
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while (true) {
//					if (socket.isConnected()) {
//						if (!socket.isInputShutdown()) {
//							try {
//								String line=null;
//								if ((line=in.readLine())!=null) {
//									content.append(line+"\n");
//									handler.sendMessage(handler.obtainMessage());
//								}
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//					}
//				}
//				
//			}
//		}).start();
	}
	private void bindSocket() {
		try {
			//指定服务器的ip地址和端口号
			socket=new Socket(IP,PORT);
			InputStream inputStream=socket.getInputStream();
			in=new BufferedReader(new InputStreamReader(inputStream));
			
			OutputStream outputStream=socket.getOutputStream();
			out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)), true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showToast(this, "端口绑定失败");
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		super.onClick(v);
		if (socket.isConnected()) {
			if (!socket.isInputShutdown()) {//是否输入通道被关闭
				out.print(msg);
			}
		}
	}
	
}
