package com.tjoven.dataStruct.leetcode.array;

public class RemoveElement {

	static int[] nums = {3,2,2,3};
	public static void main(String[] args) {
		int length = removeElement(nums, 3);
		System.out.println("length="+length);
		for (int i = 0; i < length; i++) {
			System.out.println(nums[i]);
		}
	}
	public static int removeElement(int[] nums, int val) {
        int j = 0;//不重复指针
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
