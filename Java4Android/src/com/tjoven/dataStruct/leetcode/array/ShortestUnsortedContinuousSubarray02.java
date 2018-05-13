package com.tjoven.dataStruct.leetcode.array;

public class ShortestUnsortedContinuousSubarray02 {
	static int[] nums = {2,4,5,3,10,15};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("length:"+findUnsortedSubarray(nums));
	}
	
	 public static int findUnsortedSubarray(int[] nums) {
		 //1，正序 找到开始走下坡路的最小的数
		 //2，倒叙，找到开始走上坡路后最大的数
		 //3，正序，找到第一个比最小值大的数
		 //4，倒叙，找到第一个比最大值小的数
		 boolean flag = false;
		 int min = Integer.MAX_VALUE;
		 int max = Integer.MIN_VALUE;
		 for(int i= 1;i<nums.length;i++){
			 if(nums[i-1]>nums[i]){
				 flag = true;
			 }
			 if(flag){
				min = Math.min(min, nums[i]);
			 }
		 }
		 
		 flag = false;
		 for(int i= nums.length-1;i>0;i--){
			 if(nums[i-1]>nums[i]){
				 flag = true;
			 }
			 if(flag){
				max = Math.max(max, nums[i-1]);
			 }
		 }
		 
		 int minPo = 0;
		 for(int i= 0;i<nums.length;i++){
			 if(nums[i]>min){
				 minPo = i;
				 break;
			 }
		 }
		 
		 int maxPo = 0;
		 for(int i = nums.length-1;i>=0;i--){
			 if(nums[i]<max){
				 maxPo = i;
				 break;
			 }
		 }
		 
		 return maxPo - minPo>0?maxPo - minPo+1:0;
	 }

}
