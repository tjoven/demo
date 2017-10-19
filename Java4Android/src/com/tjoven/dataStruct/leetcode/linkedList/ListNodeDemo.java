package com.tjoven.dataStruct.leetcode.linkedList;

public class ListNodeDemo {
	static ListNode node1 = new ListNode(1);
	static ListNode node2 = new ListNode(2);
	static ListNode node3 = new ListNode(3);
	static ListNode node4 = new ListNode(4);
	static ListNode node5 = new ListNode(5);
	
	public static ListNode getList(){
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		return node1;
	}
}
