package com.tjoven.dataStruct.leetcode.array;

public class MaxmiumSubarray {

	static int[] nums = {2,-1,-3,4,-1,2,1,-5,4};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(nums));
	}
	
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
