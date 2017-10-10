package com.example.composite;
/**
 * 组合模式
 * @author car
 *
 */
public class CompositePattern {
	public static void main(String[] args) {
		Dir dirC=new Folder("C");
		dirC.addDir(new File("c.txt"));
		
		Dir dirWin=new Folder("Win");
		dirWin.addDir(new File("win.txt"));
		dirC.addDir(dirWin);
		
		Dir dirOS=new Folder("OS");
		dirOS.addDir(new File("os.txt"));
		dirC.addDir(dirOS);
		
		dirC.println();
		
	}
}
