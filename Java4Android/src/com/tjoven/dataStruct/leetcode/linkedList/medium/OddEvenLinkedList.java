package com.tjoven.dataStruct.leetcode.linkedList.medium;

import com.tjoven.dataStruct.leetcode.linkedList.ListNode;

public class OddEvenLinkedList {

	static ListNode node1 = new ListNode(1);
	static ListNode node2 = new ListNode(2);
	static ListNode node3 = new ListNode(3);
	static ListNode node4 = new ListNode(4);
	static ListNode node5 = new ListNode(5);
	
	public static void main(String[] args) {
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode node = oddEvenList(node1);
		
		while(node!=null){
			System.out.println(node.val);
			node = node.next;
		}
	}
	public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode end = second.next;
        int i = 0;
        while(end!=null){
            i++;
            ListNode next = first.next;
            first.next = end;
            first = next;
            end = end.next;
        }
        if(i%2 == 0){
           first.next = second; 
        }else{
            first.next.next = second;
            first.next = null;
        }
        
        return dummy;
    }
}
