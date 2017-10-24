package com.tjoven.dataStruct.binaryTree;

import javax.xml.soap.Node;
/**
 * 求二叉树的高度
 * @author car
 *
 */
public class BinaryTreeDemo {

	public static void main(String[] args) {
		int treeHeight = getHeight(TreeNodeBuild.get());
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
