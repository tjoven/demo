package com.tjoven.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SocketAct {

	private static final int PORT = 9999;  
    private List<Socket> mList = new ArrayList<Socket>();  
    private ServerSocket server = null;  
    private ExecutorService mExecutorService = null; //thread pool  
    
	private ServerSocket serverSocket;
	
	public SocketAct() {
		try {
			 mExecutorService = Executors.newCachedThreadPool();  //create a thread pool  
			//创建一个ServerSocket对象，并让Socket在4567端口监听
			serverSocket=new ServerSocket(PORT);
			Socket socket;
			while (true) {
				//调用accept()，接受客户端的请求
				socket=serverSocket.accept();
				mList.add(socket);
				mExecutorService.execute(new Service(socket));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new SocketAct();
	}
	class Service implements Runnable{
		private Socket socket;  
        private BufferedReader in = null;  
        private String msg = ""; 
        
        public Service(Socket socket) {  
            this.socket = socket;  
            try {  
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
                msg = "user" +this.socket.getInetAddress() + "come toal:"+mList.size();  
                this.sendmsg();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }    
        
		private void sendmsg() {
			 System.out.println(msg);  
             int num =mList.size();  
             for (int index = 0; index < num; index ++) {  
                 Socket mSocket = mList.get(index);  
                 PrintWriter pout = null;  
                 try {  
                     pout = new PrintWriter(new BufferedWriter(  
                             new OutputStreamWriter(mSocket.getOutputStream())),true);  
                     pout.println(msg);  
                 }catch (IOException e) {  
                     e.printStackTrace();  
                 }  
             }  
		}


		@Override
		public void run() {
			try {  
                while(true) {  
                    if((msg = in.readLine())!= null) {  
                        if(msg.equals("exit")) {  
                            System.out.println("ssssssss");  
                            mList.remove(socket);  
                            in.close();  
                            msg = "user:" + socket.getInetAddress()  
                                + "exit total:" + mList.size();  
                            socket.close();  
                            this.sendmsg();  
                            break;  
                        } else {  
                            msg = socket.getInetAddress() + ":" + msg;  
                            this.sendmsg();  
                        }  
                    }  
                }  
            } catch (Exception e) {  
                e.printStackTrace();  
            } 
			
		}
		
	}
}
