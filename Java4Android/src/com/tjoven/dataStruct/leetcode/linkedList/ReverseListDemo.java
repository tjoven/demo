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
	

	public static ListNode reverseList(ListNode head) {
        if(head ==null ||head.next ==null) return head;
        ListNode nextNode = head.next;
        head.next = null;
        ListNode result = reverseList(nextNode);
        nextNode.next = head;
        return result;
    }

}



