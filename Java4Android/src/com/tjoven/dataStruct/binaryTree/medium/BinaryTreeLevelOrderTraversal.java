package com.tjoven.dataStruct.binaryTree.medium;

import java.util.ArrayList;
import java.util.List;

import com.tjoven.dataStruct.binaryTree.TreeNode;
import com.tjoven.dataStruct.binaryTree.TreeNodeBuild;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		List<List<Integer>> lists = levelOrder(TreeNodeBuild.get());
		System.out.println(lists);

	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		int level = 0;
		traversal(root,lists,level);
		return lists;
    }
	private static void traversal(TreeNode root, List<List<Integer>> lists,int level) {
		// TODO Auto-generated method stub
		if(root == null){
			return;
		}
		if(level<lists.size()){
			List<Integer> list = lists.get(level);
			list.add(root.val);
			lists.set(level, list);
		}else{
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			lists.add(list);
		}
		level++;
		traversal(root.left, lists, level);
		traversal(root.right, lists, level);
		
	}

}
