package com.tjoven.dataStruct.insert;

public class DoubleEntry {
	int element ;
	DoubleEntry next ;
	DoubleEntry pre ;
	public DoubleEntry(int element, DoubleEntry next, DoubleEntry pre) {
		super();
		this.element = element;
		this.next = next;
		this.pre = pre;
	}
}
