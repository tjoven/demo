package com.tjoven.dataStruct.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AverageoLevels {

	public static void main(String[] args) {
		TreeNode treeNode = TreeNodeBuild.get();
		List<Double> list = averageOfLevels(treeNode);
		System.out.println(list);
	}
	public static List<Double> averageOfLevels(TreeNode root) {
		
		ArrayList<Integer> count = new ArrayList<Integer>();//每一层节点的个数
		ArrayList<Double> sum = new ArrayList<Double>();//每一层节点val之和
		int level=0;//level
		traversal(root,count,sum,level);
		List<Double> list = new ArrayList<Double>();
		for(int i = 0;i<count.size();i++){
			double d = sum.get(i)/count.get(i);
			list.add(d);
		}
		return list;
    }
	private static void traversal(TreeNode root,ArrayList<Integer> count,ArrayList<Double> sum,int i) {
		if(root == null){
			return;
		}
		
		if(sum.size()>0 && i+1<=sum.size()){
			double mSum = sum.get(i)+root.val;
			sum.set(i, mSum);
		}else{
			sum.add(i, Double.valueOf(root.val));
		}
		
		if(count.size()>0 && i+1<=count.size()){
			count.set(i, count.get(i)+1);
		}else{
			count.add(i, 1);
		}
		i++;
		traversal(root.left, count, sum,i);
		traversal(root.right, count, sum,i);
		
	}
}
