package com.tjoven.dataStruct.leetcode.linkedList;


/**
 * 合并链表
 * @author car
 *
 */
public class MergeDemo {
	public static void main(String[] args) {
		ListNode node = mergeTwoLists(new ListNode(2), new ListNode(1));
		while (node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    
	    ListNode dummy = new ListNode(0);
	    ListNode result = dummy;
	    
	    ListNode l1Cur = l1;
	    ListNode l2Cur = l2;
	    
	    while(l1Cur!=null && l2Cur!=null ){
	        if(l1Cur.val < l2Cur.val){
	            result.next = l1Cur;
	            l1Cur = l1Cur.next;
	        }else{
	            result.next = l2Cur;
	            l2Cur = l2Cur.next;
	        }
	        result = result.next;
	    }
	    
	    if(l1Cur!=null){
	        result.next = l1Cur;
	    }
	    if(l2Cur!=null){
	        result.next = l2Cur;
	    }
	    
	    return dummy.next;
	   
	}
}



