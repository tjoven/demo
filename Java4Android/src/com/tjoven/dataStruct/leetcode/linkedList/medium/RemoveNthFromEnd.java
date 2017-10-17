package com.tjoven.dataStruct.leetcode.linkedList.medium;

import com.tjoven.dataStruct.leetcode.linkedList.ListNode;

public class RemoveNthFromEnd {
	
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
		
		ListNode node = removeNthFromEnd(node1, 5);
		
		while (node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = reverse(head);
        ListNode zero = new ListNode(0);
        zero.next = node1;
        ListNode pre = zero;
        int i=1;
        while(node1!=null ){
            
            if(i >= n){
            	pre.next = node1.next;
                node1.next = null;
                break;
            }
            
            pre = node1;
            node1 = node1.next;
            i++;
           
        }
        
        return reverse(zero.next);
    }
    private static ListNode reverse(ListNode head){
        
        if(head==null || head.next == null) return head;
        
        ListNode next = head.next;
        head.next = null;
        ListNode result = reverse(next);
        next.next = head;
        return result;
    }
}
