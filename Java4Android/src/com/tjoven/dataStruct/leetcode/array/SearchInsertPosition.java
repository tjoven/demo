package com.tjoven.dataStruct.leetcode.array;

/**
 * 
 * @author car
 *
 */
public class SearchInsertPosition {

	static int[]nums = {1,3,5,6};
	static int target = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index = searchInsert(nums,target);
		System.out.print(index);
	}
	public static int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			if(target <= a){
				return i;
			}else {
				continue;
			}
		}
		return nums.length;
    }
}
