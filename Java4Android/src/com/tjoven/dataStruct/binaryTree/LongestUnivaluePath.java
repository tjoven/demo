package com.tjoven.dataStruct.binaryTree;

public class LongestUnivaluePath {

	public static void main(String[] args) {
		TreeNode root = TreeNodeBuild.get();
		System.out.println(longestUnivaluePath2(root));
	}
	
	static int ans;
    public static int longestUnivaluePath2(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public static int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight = right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
	
    
	public static int longestUnivaluePath(TreeNode root) {
        if(root == null){
        	return 0;
        }
        
        int leftLength = longestUnivaluePath(root.left);
        int rightLength = longestUnivaluePath(root.right);
        
        boolean isLeft = false;
        boolean isRight = false;
        
        if(root.left!=null && root.left.val == root.val){
        	 leftLength++;
        	 isLeft = true;
        }
        
        if(root.right!=null && root.right.val == root.val){
        	rightLength++;
        	isRight = true;
        }
        
        if(isLeft && isRight ){
        	return leftLength + rightLength;
        }else{
        	return Math.max(leftLength, rightLength);
        }
        
    }

}
