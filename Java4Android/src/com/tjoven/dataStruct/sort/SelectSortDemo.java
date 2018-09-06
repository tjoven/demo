package com.tjoven.dataStruct.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 	循环N此，选择最大/最小的值，放在指定的位置
 * @author tjoven
 *
 */
public class SelectSortDemo {
	
	static int[] array2 = {10,22,14,63,48,1,12};
//	static int[] array2 = {1,2,3,4,8,11,12};
	
	public static void main(String[] args) {
		int[] result = selectSort(array2);
		for (int i : result) {
			System.out.println(i);
		}
	}
	
	private static int[] selectSort(int[] arrs){
		for (int i = 0; i < arrs.length; i++) {
			int minIndex = i;
			for (int j = i+1; j < arrs.length; j++) {
				if(arrs[minIndex] > arrs[j]){
					minIndex = j;
				}
			}
			swap(arrs,i,minIndex);
		}
		return arrs;
	}
	
	private static void swap(int[] array ,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
