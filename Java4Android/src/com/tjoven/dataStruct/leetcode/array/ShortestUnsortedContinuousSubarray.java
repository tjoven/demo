package com.tjoven.dataStruct.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 * @author tjoven
 *
 */
public class ShortestUnsortedContinuousSubarray {
	static int[] nums = {2,4,5,3,10,15};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("length:"+findUnsortedSubarray(nums));
		
	}
	
	 public static int findUnsortedSubarray(int[] nums) {
		 int[] copy = nums.clone();
		 Arrays.sort(copy);
		 int leftmost = 0;
		 int rightmost = nums.length-1;
		 boolean leftB = false;
		 boolean rightB = false;
		 for(int i = 0;i<nums.length;i++){
			 if(copy[i] != nums[i] &&!leftB){
				 //leftmost
				 leftmost = i;
				 leftB = true;
			 }
			 int right = nums.length - i - 1;
			 if(copy[right] != nums[right] && !rightB){
				 //leftmost
				 rightmost = right;
				 rightB = true;
			 }
		 }
		 if(!leftB && !rightB){
			 return 0; 
		 }
		 return rightmost-leftmost+1;
	 }

}
