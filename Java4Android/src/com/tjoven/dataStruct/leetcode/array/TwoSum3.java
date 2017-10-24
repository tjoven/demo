package com.tjoven.dataStruct.leetcode.array;

import java.util.HashSet;
import java.util.Set;

import com.tjoven.dataStruct.binaryTree.TreeNode;

public class TwoSum3 {

	public static void main(String[] args) {
		System.out.println(findTarget(null, 1));
	}
	
	public static boolean findTarget(TreeNode root, int k) {
        Set set =new  HashSet<Integer>();
        boolean b = true;
        traverse(root,set,k,b);
		return b;
        
        
    }
    private static void traverse(TreeNode root, Set set,int k,boolean b){
        if(root==null){
            return ;
        }
        traverse(root.left, set, k,b);
        traverse(root.right, set, k,b);
        if(set.contains(k-root.val)){
        	b = true;
        }
        set.add(root.val);
    }
}
