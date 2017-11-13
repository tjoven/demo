package com.tjoven.dataStruct.binaryTree;

public class trimBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = trimBST(TreeNodeBuild.get(), 1, 2);
		System.out.println(node.val);
		System.out.println(node.left);
		System.out.println(node.right.val);
	}
	
	public static TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }
        if(root.val < L){
            root = trimBST(root.right,L,R);
        }else if(root.val > R){
            root = trimBST(root.left,L,R);
        }else{
        	 trimBST(root.left,L,R);
        	 trimBST(root.right,L,R);
        }
        return root;
    }

}
