package com.tjoven.dataStruct.leetcode.linkedList.medium;

import java.util.Arrays;

import com.tjoven.dataStruct.leetcode.linkedList.ListNode;
import com.tjoven.dataStruct.leetcode.linkedList.ListNodeDemo;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 * @author tjoven
 *
 */
public class SplitLinkedListInParts02 {

	static int K = 6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] node = splitListToParts(ListNodeDemo.getList(), K);
		for (int i = 0; i < node.length; i++) {
			ListNode entry = node[i];
			
			while (entry!=null) {
				System.out.print(entry.val+"  ");
				entry = entry.next;
			}
			System.out.println("----------");
		}
			
	}
	
	public static ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] result = new ListNode[k];
		int length = getLentgh(root);
		int baseLen = length/k;
		int extraLen = length%k;
		
		//1,分成k部分
		//2，每部分长度baseLen+1 or baseLen
		//3，遍历链表 找到每个part的head
		
		ListNode pre = null;
		for(int i = 0;i<k;i++){
			result[i] = root;
			int partLen = baseLen+(i<extraLen?1:0);
			for(int j=0;j<partLen;j++){
				pre = root;
				if(root!=null){
					root = root.next;
				}
				
			}
			if(pre!=null){
				pre.next = null;
			}
			
		}
		return result;
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
