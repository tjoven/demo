	package com.tjoven.dataStruct.leetcode.array;

import java.util.ArrayList;

public class PascalTriangle {

	static int numRows = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = generate(numRows);
		System.out.println(result.toString());
	}

	public  static ArrayList<ArrayList<Integer>> generate(int numRows) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList();
		 ArrayList<Integer> preItem = new ArrayList();
		 for(int i = 0;i<numRows;i++){
			 ArrayList<Integer> item = new ArrayList();
			 for(int j=0;j<=i;j++){
				 int num = 1;
				 if(j==0 ||j==i){
					 num = 1;
				 }else{
					 num = preItem.get(j)+preItem.get(j-1);
				 }
				 item.add(num);
			 }
			 result.add(item);
			 preItem = item;
		 }
		return result;
    }
}
