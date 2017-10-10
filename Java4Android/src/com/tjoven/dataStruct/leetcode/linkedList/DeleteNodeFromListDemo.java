package com.tjoven.dataStruct.leetcode.linkedList;

/**
 * 删除单链表中的元素
 * @author car
 *
 */
public class DeleteNodeFromListDemo {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next =node3;
		node3.next = node4;
//		node4.next = node2;
		
		ListNode node = delete(node1, 2);
		
		while (node!=null) {
			System.out.println(node.val);
			node = node.next;
			
		}
	}
	private static ListNode delete(ListNode head,int val){
		ListNode node = new ListNode(-1);
		ListNode preNode = node;
		node.next = head;

		while(head!=null ){
			if (head.val == val) {
				preNode.next = head.next;
			}else{
				preNode = head;
			}
			
			head = head.next;
		}
		
		return node.next;
		
	}
}
