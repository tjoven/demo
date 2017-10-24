package com.tjoven.dataStruct.binaryTree;

import java.util.HashSet;
import java.util.Set;

import com.tjoven.dataStruct.binaryTree.TreeNode;

public class TwoSum3 {

	public static void main(String[] args) {
		System.out.println(findTarget(TreeNodeBuild.get(), 5));
	}
	
	public static boolean findTarget(TreeNode root, int k) {
        Set set = new HashSet<Integer>();
        return traverse(root,k,set);
    }
    private static boolean traverse(TreeNode root,int k,Set set){
        if(root == null){
            return false;
        }
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        boolean leftB = traverse(root.left,k,set);
        boolean rightB = traverse(root.right,k,set);
        return leftB||rightB;
    }
}
