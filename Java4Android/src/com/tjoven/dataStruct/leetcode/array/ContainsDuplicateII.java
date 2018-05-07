package com.tjoven.dataStruct.leetcode.array;

import java.util.HashSet;
import java.util.Set;
/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 * @author car
 *
 */
public class ContainsDuplicateII {

	static int[] nums={99,99};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = containsNearbyDuplicate(nums,2);
		System.out.println( b);
	}
	
	/**
	 * 这个思路 很棒
	 * 维持一个容量为K的set，判断这个set里面是否有重复项
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>(k);
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

}
