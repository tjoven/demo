package com.tjoven.dataStruct.binaryTree;


public class SubtreeofAnotherTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null){
			return false;
		}
		if(compare(t, s)){
			return true;
		}else{
			return isSubtree(s.left, t) || isSubtree(s.right, t);
		}
		
    }

	
	private static boolean compare(TreeNode t, TreeNode s){
		if(s==null && t==null){
			return true;
		}else if(s!=null && t!=null && s.val == t.val){
			return compare(s.left,t.left) && compare(s.right, t.right);
			
		}else{
			return false;
		}
	}

}
