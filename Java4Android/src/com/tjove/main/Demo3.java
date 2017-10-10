package com.tjove.main;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Demo3 {
	public static void main(String[] args) {
		Demo3 demo3=new Demo3();
		
		demo3.reader1();
		demo3.reader2();
		demo3.reader3();
	}
	
	/**
	 * 字符流 Reader--->FileReader
	 */
	void reader1(){
		char[] c=null;
		CharArrayWriter charArrayWriter=new CharArrayWriter();
		try {
			FileReader reader=new FileReader("e:/src/aa.txt");
			c=new char[10];
			while ((reader.read(c, 0, c.length))!=-1) {
				charArrayWriter.write(c, 0, c.length);
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("FileReader的结果：   "+new String(charArrayWriter.toCharArray()));
		
	}
	
	/**
	 * 字节流 InputStream--->FileInputStream
	 */
	void reader2(){
		byte[] buffer=null;
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		try {
			FileInputStream reader=new FileInputStream("e:/src/aa.txt");
			buffer=new byte[1024];
			while ((reader.read(buffer, 0, buffer.length)!=-1)) {
				byteArrayOutputStream.write(buffer);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("FileInputStream的结果：   "+new String(byteArrayOutputStream.toByteArray()));
		
	}
	/**
	 * 装饰--->BufferedReader
	 */
	void reader3(){
		byte[] buffer=null;
		String content=null;
		StringBuffer stringBuffer=null;
		String line=null;
		try {
			FileInputStream fileInputStream=new FileInputStream("e:/src/aa.txt");
			InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
			BufferedReader reader=new BufferedReader(inputStreamReader);
			
			stringBuffer=new StringBuffer();
			while ((line=reader.readLine())!=null) {
				stringBuffer.append(line);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("BufferedReader的结果：   "+stringBuffer.toString());
		
	}

}
