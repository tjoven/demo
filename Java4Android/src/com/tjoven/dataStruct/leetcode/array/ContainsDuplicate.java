package com.tjoven.dataStruct.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	static int[] nums = {1,2,3,4,5,6,7,8,1};
	public static void main(String[] args) {
		boolean b = containsDuplicate(nums);
		System.out.println(b);
	}
	
	public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (Integer i : nums) {
        	 if(set.contains(i)){
             	return true;
             }
        	 set.add(i);
		}
        return false;
    }
}
