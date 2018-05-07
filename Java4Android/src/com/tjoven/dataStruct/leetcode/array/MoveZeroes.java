package com.tjoven.dataStruct.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 * @author car
 *
 */
public class MoveZeroes {

	static int[] nums = {2, 1, 1, 3, 12};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		moveZeroes(nums);
		System.out.print(Arrays.toString(nums));
	}
	
	public static void moveZeroes(int[] nums) {
		int index = 0;
		int zeroLen = 0;
        for (int i = 0;i<nums.length;i++) {
			if(nums[i] != 0){
				nums[index] = nums[i];
				index++;
			}else{
				zeroLen++;
			}
		}
        
        for(int i = nums.length-1;i>=nums.length-zeroLen;i--){
        	nums[i] = 0;
        }
    }

	private void exchange(int a,int b){
		int temp;
		temp = a;
		a= b;
		b = temp;
	}
}
