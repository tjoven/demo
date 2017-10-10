package com.example.facade;

public class MobilePhone {
	PhoneImpl phoneImpl=new PhoneImpl();
	CameraImpl cameraImpl=new CameraImpl();
	public void call() {
		phoneImpl.call();

	}
	public void videoChat() {
		System.out.println("准备视频通话");
		cameraImpl.open();
		phoneImpl.call();

	}
	public void takePicture() {
		cameraImpl.takePicture();
		
	}
}
