package com.example.facade;

public class CameraImpl implements Camera{

	@Override
	public void open() {
		System.out.println("打开相机");
		
	}

	@Override
	public void takePicture() {
		System.out.println("照相");
		
	}

	@Override
	public void close() {
		System.out.println("关闭相机");
		
	}

}
