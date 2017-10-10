package com.example.composite;

import java.util.ArrayList;

public class File extends Dir{

	public File(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addDir(Dir dir) {
		throw new UnsupportedOperationException("文件对象不支持这操作");
		
	}

	@Override
	public void removeDir(Dir dir) {
		throw new UnsupportedOperationException("文件对象不支持这操作");
		
	}

	@Override
	public void clearDir() {
		throw new UnsupportedOperationException("文件对象不支持这操作");
		
	}

	@Override
	public ArrayList<Dir> getDirs() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("文件对象不支持这操作");
	}


	@Override
	public void println() {
		System.out.print(getName()+" ");
		
	}

}
