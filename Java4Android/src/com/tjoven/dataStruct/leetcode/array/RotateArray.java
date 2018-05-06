package com.tjoven.dataStruct.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/description/
 * @author car
 *
 */
public class RotateArray {

	static int[] nums = {1,2,3,4,5,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rotate03(nums, 15);
		System.out.println(Arrays.toString(nums));
	}

	public static void rotate(int[] nums, int k) {
        for (int i = 0; i <k; i++) {
        	int last = nums[nums.length-1];
        	System.arraycopy(nums, 0, nums, 1,nums.length-1);
        	nums[0] = last;
		}
    }
	
	public static void rotate02(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
        	int newIndex = (i+k)%nums.length;
        	result[newIndex] = nums[i];
        }
        
        System.out.println(Arrays.toString(result));
    }
	
	/**
	 * Using Reverse
	 * @param nums
	 * @param k
	 */
	public static void rotate03(int[] nums, int k) {
		k = k%nums.length;
		reverse(nums,0,nums.length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);
        
    }
	
	static void reverse(int[] nums,int start,int end){
		int temp;
		int i = 0;
		while(start+i<=end-i){
			temp = nums[start+i];
			nums[start+i] = nums[end -i];
			nums[end - i] = temp;
			i++;
		}
	}
}
