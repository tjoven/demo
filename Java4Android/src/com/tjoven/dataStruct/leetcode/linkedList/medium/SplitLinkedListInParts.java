package com.tjoven.dataStruct.leetcode.linkedList.medium;

import java.util.Arrays;

import com.tjoven.dataStruct.leetcode.linkedList.ListNode;
import com.tjoven.dataStruct.leetcode.linkedList.ListNodeDemo;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 * @author tjoven
 *
 */
public class SplitLinkedListInParts {

	static int K = 6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] node = splitListToParts(ListNodeDemo.getList(), K);
		for (int i = 0; i < node.length; i++) {
			ListNode entry = node[i];
			System.out.println("----------");
			while (entry!=null) {
				System.out.print(entry.val+"  ");
				entry = entry.next;
			}
		}
			
	}
	
	public static ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] result = new ListNode[k];
		int[] lengths = new int[k];
		int[] indexs = new int[k];
		
		//1,获取链表的长度
		//2,链表分成k部分，每部分的长度是多少
		//3,获取每一部分的head，并将end.next = null
		
		int length = getLentgh(root);
		int baseLen = length/k;//平均分，每一部分的长度
		int extraSize = length%k; //剩余的长度，平均分给前几个part
		//把每一部分的长度用一个数组来保管
		for(int i = 0;i<k;i++){
			if(i<extraSize){
				lengths[i] = baseLen+1;
			}else {
				lengths[i] = baseLen;
			}
		}
		//每一个partHead的index
		for(int i = 0;i<k;i++){
			int index = 0;
			for(int j = 0;j<i;j++){
				index+=lengths[j];
			} 
			indexs[i] = index;
		}
		
		int partIndex = 0;
		int rootIndex = 0;
		ListNode pre = null;
		while(root!=null && partIndex<k){
			if(rootIndex == indexs[partIndex]){
				result[partIndex] = root;
				partIndex++;
				if(pre!=null){
					pre.next = null;
				}
			}
			pre = root;
			root = root.next;
			rootIndex++;
		}
		
		for(int i = partIndex;i<k;i++){
			result[partIndex] = null;
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
