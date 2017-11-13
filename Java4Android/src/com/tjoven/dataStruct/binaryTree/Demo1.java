package com.tjoven.dataStruct.binaryTree;

/**
 * 引用到底是怎么传值的，这样为什么不行
 * @author tjoven
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		com.tjoven.dataStruct.binaryTree.TreeNode node = TreeNodeBuild.get();
		change(node);
		System.out.println(node.left);
	}
	static void change(com.tjoven.dataStruct.binaryTree.TreeNode node){
		node = null;
	}
}
