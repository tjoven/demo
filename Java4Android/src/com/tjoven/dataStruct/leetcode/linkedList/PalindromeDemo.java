package com.tjoven.dataStruct.leetcode.linkedList;

/**
 * 回文
 * @author car
 *
 */
public class PalindromeDemo {

	
//	ListNode node6 = new ListNode(1);
	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1); 
		ListNode node2 = new ListNode(2); 
		ListNode node3 = new ListNode(3); 
		ListNode node4 = new ListNode(3); 
		ListNode node5 = new ListNode(2); 
		ListNode node6 = new ListNode(9); 
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		boolean b = isPalindrome(node1);
		System.out.println("回文："+b);
	}
	public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode faster = head;
        ListNode pre = null;
        
        
        while(faster != null){
        	pre = slow;
        	slow = slow.next;
        	if(faster.next !=null){
        		faster = faster.next.next;
        	}else{
        		break;
        	}
        	
        }
        pre.next = null;
        ListNode part2 = null;
        
    	part2 = reverse(slow);
        
        while (head.val == part2.val) {
        	head = head.next;
        	part2 = part2.next;
        	if(head==null || part2==null){
        		return true;
        	}
		}
        return false;
        
         
    }
	
	/**
	 * 翻转
	 */
	private static ListNode reverse(ListNode head){
		ListNode preNode = null;
		ListNode nextNode = null;
		
		while(head!=null){
			nextNode = head.next;
			head.next = preNode;
			preNode = head;
			head = nextNode;
		}
		return preNode;
		
	}
}
