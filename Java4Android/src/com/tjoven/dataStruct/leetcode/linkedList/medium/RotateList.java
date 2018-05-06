package com.tjoven.dataStruct.leetcode.linkedList.medium;

import com.tjoven.dataStruct.leetcode.linkedList.ListNode;
import com.tjoven.dataStruct.leetcode.linkedList.ListNodeDemo;

public class RotateList {
	static int K = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode node = rotateRight(ListNodeDemo.getList(),K);
		
		while (node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		k = k%getLentgh(head);
		ListNode dummy = new ListNode(0);
		ListNode curNode = head;
		ListNode nextNode = head;
		int i = 0;
		while(curNode.next!=null){
			curNode = curNode.next;
			if(i>=k){
				nextNode = nextNode.next;
			}
			i++;
		}
		curNode.next = head;
		dummy.next = nextNode.next;
		nextNode.next = null;
		return dummy.next;
        
    }
	
	private static int getLentgh(ListNode head){
		int length = 0;
		while(head!=null){
			length++;
			head = head.next;
		}
		
		return length;
	}

}
