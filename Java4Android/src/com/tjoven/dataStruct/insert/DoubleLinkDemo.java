package com.tjoven.dataStruct.insert;

public class DoubleLinkDemo {

	static DoubleEntry entry1 = new DoubleEntry(1, null,null);
	static DoubleEntry entry2 = new DoubleEntry(2, null,null);
	static DoubleEntry entry3 = new DoubleEntry(3, null,null);
	
	public static void main(String[] args) {
		
		entry1.next = entry2;
		entry2.next = entry3;
		
		entry3.pre = entry2;
		entry2.pre = entry1;
		
		DoubleEntry entry4 = new DoubleEntry(4, entry3,entry2);
		addEntry(entry4);
		
		removeEntry2(entry2);
		
	}

	private static void removeEntry2(DoubleEntry entry2) {
		entry2.pre.next = entry2.next;
		entry2.next.pre = entry2.pre;
		
		entry2.pre = null;
		entry2.next = null;
		
		System.out.println("-----------");
		
		DoubleEntry e = entry1;
		while (e!=null) {
			System.out.println(e.element);
			e = e.next;
			
		}
	}

	private static void addEntry(DoubleEntry entry4) {
		
//		entry3.pre.next = entry4;
//		entry3.pre = entry4;
		entry4.pre.next = entry4;
		entry4.next.pre = entry4;
		
		
		DoubleEntry entry = entry1;
		while (entry!=null) {
			System.out.println(entry.element);
			entry = entry.next;
			
		}
		
		System.out.println("-----------");
		
		DoubleEntry e = entry3;
		while (e!=null) {
			System.out.println(e.element);
			e = e.pre;
			
		}
	}
}
