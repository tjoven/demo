package com.tjoven.dataStruct.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

	static int[] numbers={2, 7, 11, 15};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = twoSum(numbers, 9);
		
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(numbers[i])){
                result[0] = map.get(numbers[i])+1;
                result[1] = i+1;
                return result;
            }else{
                map.put(target-numbers[i],i);
            }
            
        }
        return result;
    }
}
