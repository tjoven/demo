package com.tjoven.dataStruct.leetcode.array;


public class MaxmiumSubarray {

	static int[] nums = {2,-1,-3,4,-1,2,1,-5,4};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(nums));
	}
	
	
	/**
	 * 题解：
		这道题要求 求连续的数组值，加和最大。
 		试想一下，如果我们从头遍历这个数组。对于数组中的其中一个元素，它只有两个选择：
 			1. 要么加入之前的数组加和之中（跟别人一组）
 			2. 要么自己单立一个数组（自己单开一组）
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums){
          //    Solution 1:  O(n)
          // check param validation.
          if(nums == null || nums.length == 0)
              return 0;
          
         int sum = 0;
         int max = Integer.MIN_VALUE;
  
         // iterate nums array.
         for (int i = 0; i < nums.length; i++) 
         {
            // choose a larger one between current number or (previous sum + current number).
             sum = Math.max(nums[i], sum + nums[i]);
             max = Math.max(max, sum);    // choose the larger max.
         }
  
         return max;
     }

}
