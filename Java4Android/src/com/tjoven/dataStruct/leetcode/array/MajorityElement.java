package com.tjoven.dataStruct.leetcode.array;

import java.util.HashMap;

public class MajorityElement {

	static int[] nums = {1,2,2,4,4,1,1,1,1,6,1,1,1,1,1,1};
	public static void main(String[] args) {
		MajorityElement element = new MajorityElement();
		int result = element.majorityElement02(nums);
		System.out.println(result);
	}
	
	void play(){
		HashMap<Integer, Integer> map = new HashMap();
		map.put(1, 10);
		map.put(1, 20);
		System.out.println(map.get(1));
	}
	
	public static int majorityElement02(int[] nums) {
		Integer temp = null;
		int count = 0;
		for (int num : nums) {
			if(count == 0){
				temp = num;
			}
			
			if(temp == num){
				count++;
			}else{
				count--;
			}
		}
		return temp;
		
	}
	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap();
		for(int i = 0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				int time = map.get(nums[i]);
				time++;
				map.put(nums[i], time);
			}else{
				map.put(nums[i], 1);
			}
			
			if(map.get(nums[i])>nums.length/2){
				return nums[i];
			}
		}
		return 0;
    }
}
