package com.tjoven.dataStruct.insert;

/**
 * 单链表 
 * 增加元素
 * @author car
 *
 */
public class SingleLinkDemo {

	static SingleEntry entry3 = new SingleEntry(3, null);
	static SingleEntry entry2 = new SingleEntry(2, entry3);
	static SingleEntry entry1 = new SingleEntry(1, entry2);
	
	public static void main(String[] args) {
		
		SingleEntry entry = entry1;
		while (entry!=null) {
			System.out.println(entry.element);
			entry = entry.next;
			
		}
		
		System.out.println("------------------------------");
		
		SingleEntry entry4 = new SingleEntry(4, null);
		addEntry(entry4);
		remove(entry2);
		
	}

	/**
	 * 删掉entry1
	 * @param entry4
	 */
	private static void remove(SingleEntry entry2) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * entry3 之前增加entry4
	 * @param entry4
	 */
	private static void addEntry(SingleEntry entry4) {
		
		entry2.next = entry4 ;
		entry4.next = entry3;
		SingleEntry entry = entry1;
		while (entry!=null) {
			System.out.println(entry.element);
			entry = entry.next;
		}
	}
}
