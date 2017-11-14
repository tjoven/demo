package com.tjoven.dataStruct.binaryTree;


public class FindSecondMinimumValue {

	int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private int findSecondMinimumValue(TreeNode node){
		int min = node.val;
		
		travel(node,min);
		
		return result==Integer.MAX_VALUE ? -1:result;
		
	}
	private void travel(TreeNode node,int min) {

		if(node == null){
			return ;
		}
		if(node.val > min && node.val < result){
			result = node.val;
		}else if(node.val == min){
			travel(node.left,min);
			travel(node.right,min);
		}
		
		
	}

}
