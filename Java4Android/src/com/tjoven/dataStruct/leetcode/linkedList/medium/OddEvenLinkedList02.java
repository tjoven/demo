package com.tjoven.dataStruct.leetcode.linkedList.medium;

import com.tjoven.dataStruct.leetcode.linkedList.ListNode;
import com.tjoven.dataStruct.leetcode.linkedList.ListNodeDemo;

public class OddEvenLinkedList02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = oddEvenList(ListNodeDemo.getList());
		while(node!=null){
			System.out.println(node.val);
			node = node.next;
		}
	}
	
	public static ListNode oddEvenList(ListNode head) {
		if(head == null){
			return head;
		}
		ListNode dummy = head;
		ListNode odd = head;//奇数节点
		ListNode even = head.next;//偶数节点
		ListNode second = head.next;//
		while(odd!=null && even!=null&& even.next!=null){
			odd.next = even.next;
			odd = even.next;
			even.next = odd.next;
			even = odd.next;
		}
		
		odd.next = second;
		return dummy;
		 
	 }

}
