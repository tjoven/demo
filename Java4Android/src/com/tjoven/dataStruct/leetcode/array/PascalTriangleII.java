package com.tjoven.dataStruct.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

	static int numRows = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = getRow(numRows);
		System.out.println(result.toString());
	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<=rowIndex;i++){
			list.add(1);
			for(int j = list.size()-2;j>0;j--){
				list.set(j, list.get(j)+list.get(j-1));
			}
		}
		return list;
        
    }
}
