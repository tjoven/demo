package com.tjoven.dataStruct.leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表是否又环
 * @author car
 *
 */
public class ListCycleDemo {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next =node3;
		node3.next = node4;
		node4.next = node2;
		
		
		System.out.println(hasCycle2(node1));
	}
	
	    public static boolean hasCycle(ListNode head) {
	        Set set = new HashSet<ListNode>();
	        while(head!=null){
	            if(set.contains(head)){
	                return true;
	            }
	            set.add(head);
	            head = head.next;
	        }
	        return false;
	    }
	    
	    public static boolean hasCycle2(ListNode head) {
	    	if(head == null || head.next == null){
	            return false;
	        }
	        ListNode slower = head;
	        ListNode faster = head.next; 
	        
	        while(slower !=null && faster != null&& faster.next != null){
	            if(slower == faster) return true;
	            slower = slower.next;
	            faster = faster.next.next;
	        }
	        return false;
	    }
}
