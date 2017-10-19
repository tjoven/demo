package com.tjoven.dataStruct.leetcode.linkedList.medium;

import com.tjoven.dataStruct.leetcode.linkedList.ListNode;
import com.tjoven.dataStruct.leetcode.linkedList.ListNodeDemo;

public class ReverseLinked2 {

	public static void main(String[] args) {
		ListNode node = ListNodeDemo.getList();
		ListNode result = reverseBetween(node, 2, 4);
		
		while (result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start = null;
        ListNode end = null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre1 = null;
        for(int i=1;i<m;i++){
            pre1 = head;
            head = head.next;
        }
        
        start = head;
        ListNode pre2 = null;
        for(int j=m;j<=n;j++){
            ListNode next = head.next;
            head.next = pre2;
            pre2 = head;
            head = next;
        }
        end = pre2;
        
        start.next = head;
        pre1.next = end;
        return dummy.next;
        
    }
}
