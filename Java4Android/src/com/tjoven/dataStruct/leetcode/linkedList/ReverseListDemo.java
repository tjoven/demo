package com.tjoven.dataStruct.leetcode.linkedList;

/**
 * 链表翻转
 * @author car
 *
 */
public class ReverseListDemo {
	public static void main(String[] args) {
		ListNode origin = new ListNode(1);
		origin.next = new ListNode(2);
		ListNode node = reverseList(origin);
		while (node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	

	
	private static ListNode reverseList(ListNode origin) {
		// TODO Auto-generated method stub
		if (origin == null || origin.next == null) {
			return origin;
		}
		ListNode nextNode = origin.next;
		origin.next = null;
		ListNode result = reverseList(nextNode);
		nextNode.next = origin;
		return result;
	}


	private static ListNode reverseList2(ListNode origin) {
		// TODO Auto-generated method stub
		ListNode pre = null;
		ListNode now = origin;
		while (now!=null) {
			ListNode temp = now.next;
			now.next = pre;
			pre = now;
			now = temp;
			
		}
		return pre;
	}

}



