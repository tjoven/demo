package com.example.composite;

import java.util.ArrayList;
import java.util.Iterator;

public class Folder extends Dir{

	public Folder(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addDir(Dir dir) {
		dirs.add(dir);
		
	}

	@Override
	public void removeDir(Dir dir) {
		dir.removeDir(dir);
		
	}

	@Override
	public void clearDir() {
		dirs.clear();
		
	}

	@Override
	public ArrayList<Dir> getDirs() {
		
		return dirs;
	}

	@Override
	public void println() {
		System.out.print(getName()+"( ");
		Iterator iterator = dirs.iterator();
		while (iterator.hasNext()) {
			Dir dir = (Dir) iterator.next();
			dir.println();
			if (iterator.hasNext()) {
				System.out.print(",");
			}
		}
		System.out.print(" )");
	}

}
