package com.example.composite;

import java.util.ArrayList;

public abstract class Dir {
	ArrayList<Dir> dirs=new ArrayList<Dir>();
	String name;
	public Dir(String name) {
		this.name=name;
	}
	public abstract void addDir(Dir dir);
	public abstract void removeDir(Dir dir);
	public abstract void clearDir();
	
	public  abstract ArrayList<Dir> getDirs();
	
	public String getName(){
		return name;
	}
	public abstract void println();
}
