package com.tjoven.dataStruct.leetcode.linkedList.medium;

import com.tjoven.dataStruct.leetcode.linkedList.ListNode;

public class AddNumbers {

	static ListNode l1 = new ListNode(5);
	static ListNode l1a = new ListNode(4);
	static ListNode l1b = new ListNode(3);
	static ListNode l1c = new ListNode(9);
	
	
	static ListNode l2 = new ListNode(5);
	static ListNode l2a = new ListNode(6);
	static ListNode l2b = new ListNode(4);
			
	public static void main(String[] args) {
		l1.next = l1a;
		l1a.next = l1b;
		l1b.next = l1c;
		
		l2.next = l2a;
		l2a.next = l2b;
		
		ListNode result = addTwoNumbers(l1, l2);
		while (result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		int carry = 0;
		ListNode pre = new ListNode(0);
		ListNode dummy = pre;
		while (l1!=null || l2!=null) {
			int p = (l1==null?0:l1.val);
			int q = (l2==null?0:l2.val);
			
			int sum = p+q+carry;
			ListNode now = new ListNode(sum%10);
			pre.next = now;
			carry = (sum>=10) ?1:0;
			pre = now;
			l1 = (l1==null) ? null : l1.next;
			l2 = (l2==null) ? null : l2.next;;
		}
		
		if (carry == 1) {
			ListNode node = new ListNode(carry);
			pre.next = node;
		}
		return dummy.next;
    }
}
