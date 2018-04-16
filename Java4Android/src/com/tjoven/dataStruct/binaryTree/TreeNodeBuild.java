package com.tjoven.dataStruct.binaryTree;

public class TreeNodeBuild {
	static TreeNode node6 = new TreeNode(5,null,null);
	static TreeNode node5 = new TreeNode(5,null,null);
	static TreeNode node4 = new TreeNode(1,null,null);
	static TreeNode node3 = new TreeNode(4,null,null);
	
	static TreeNode node2 = new TreeNode(5,null,node6);
	static TreeNode node1 = new TreeNode(4,node3,null);
	static TreeNode node0 = new TreeNode(1,node1,node2);
	
	public static TreeNode get(){
		return node0;
	}

}
