package com.tjoven.dataStruct.leetcode.array;

public class RemoveDuplicatesDemo {

	public static void main(String[] args) {
		int[] nums = {1,1,2,2,3,3,3,4,5,6,7};
		int length = removeDuplicates(nums);
		System.out.println("length:"+length);
	}
	
	
	public static int removeDuplicates(int[] nums) {
        int i = 0;//慢的
        int j=1;//快的
        while (j<nums.length) {
			if (nums[i] != nums[j]) {
				nums[i+1] = nums[j];
				i++;
				j++;
			}else{
				j++;
			}
			
		}
        return i+1;
    }
}
