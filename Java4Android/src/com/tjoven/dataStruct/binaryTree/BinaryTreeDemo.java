package com.tjoven.dataStruct.binaryTree;

import javax.xml.soap.Node;
/**
 * 求二叉树的高度
 * @author car
 *
 */
public class BinaryTreeDemo {

	static TreeNode node6 = new TreeNode(6,null,null);
	static TreeNode node5 = new TreeNode(5,null,null);
	static TreeNode node4 = new TreeNode(4,null,null);
	static TreeNode node3 = new TreeNode(3,null,null);
	static TreeNode node2 = new TreeNode(2,node5,node6);
	static TreeNode node1 = new TreeNode(1,node3,node4);
	static TreeNode node0 = new TreeNode(0,node1,node2);
	
	public static void main(String[] args) {
		int treeHeight = getHeight(node0);
		System.out.println("BinaryTree高度="+treeHeight);
	}
	static int getHeight(TreeNode root){
		
		int h = 0;
		if (root == null) {
			return 0 ;
		}
		int leftH = getHeight(root.left);
		int rightH = getHeight(root.right);
		
		h = leftH > rightH ? leftH+1 : rightH+1;
		
		return h;
	}
	
	
}
