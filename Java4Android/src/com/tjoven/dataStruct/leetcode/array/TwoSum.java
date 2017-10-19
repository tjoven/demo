package com.tjoven.dataStruct.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	static int[] arrays = {2,3,4};
	public static void main(String[] args) {
		int[] re = twoSum(arrays,6);
		if(re == null){
			System.out.println("Null");
			return;
		}
		for (int i : re) {
			System.out.println(i);
		}
	}
	
	public static int[] twoSum2(int[] nums, int target) {
        Map map = new HashMap<Integer,Integer>(nums.length);
        for(int i=0;i<nums.length;i++){
        	boolean b = map.containsKey(target - nums[i]);
            if(b){
         	   int[] as = new int[2];
         	   as[0] = (Integer) map.get(target - nums[i]);
         	   as[1] = i;
         	   return as;
         	   
            }
            map.put(nums[i], i);
        }
        
        return null;
    }
	
	public static int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<Integer,Integer>(nums.length);
        for(int i=0;i<nums.length;i++){
            map.put(target-nums[i], i);
        }
        
        for(int j =0;j<nums.length;j++){
           boolean b = map.containsKey(nums[j]);
           if(b){
        	   int[] as = new int[2];
        	   as[0] = (Integer) map.get(nums[j]);
        	   as[1] = j;
        	   if(as[0]!=as[1]){
        		   return as;
        	   }
           }
        }
        return null;
    }
}
