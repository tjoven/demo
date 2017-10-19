package com.tjoven.dataStruct.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	static int[] arrays = {1,2,3,5};
	public static void main(String[] args) {
		int[] re = twoSum(arrays, 4);
		for (int i : re) {
			System.out.println(i);
		}
	}
	public static int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<Integer,Integer>(nums.length);
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        
        for(int j =0;j<nums.length;j++){
           boolean b = map.containsKey(nums[j]);
           if(b){
        	   int[] as = new int[2];
        	   as[0] = (Integer) map.get(nums[j]);
        	   as[1] = j;
        	   return as;
           }
        }
        return null;
    }
}
