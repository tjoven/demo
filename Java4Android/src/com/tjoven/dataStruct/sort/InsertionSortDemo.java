package com.tjoven.dataStruct.sort;

/**
 * 直接插入排序
 * 	将一个记录插入到已经排好序的列表中
 * @author tjoven
 *
 */
public class InsertionSortDemo {

	static int[] array2 = {10,22,14,63,48,1,12};
//	static int[] array2 = {1,2,3,4,8,11,12};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = insertSort(array2);
		for (int i : result) {
			System.out.println(i);
		}
	}
	
	private static int[] insertSort(int[] arrs){
		
		for (int i = 1; i < arrs.length; i++) {
			int j = i-1;
			int temp = arrs[i];
			while(j>=0 && temp < arrs[j]){
				arrs[j+1] = arrs[j];
				j--;
			}
			arrs[j+1] = temp;
		}
		return arrs;
	}
	
	private static void swap(int[] array ,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}


}
