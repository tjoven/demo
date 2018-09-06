package com.tjoven.dataStruct.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 	相邻两个元素比较，两个元素顺序排列
 * @author tjoven
 *
 */
public class BubbleSortDemo {
	
//	static int[] array2 = {10,22,14,63,48,1,12};
	static int[] array2 = {1,2,3,4,8,11,12};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = bubbleSort(array2);
		for (int i : result) {
			System.out.println(i);
		}
	}
	
	private static int[] bubbleSort(int[] arrs){
		boolean needSort = true;
		int k = 0;
		for(int i = 0 ;i < arrs.length && needSort ; i++){
			needSort = false;
			for(int j = 0 ; j < arrs.length-i-1; j++){
				if(arrs[j] > arrs[j+1]){
					needSort = true;
					swap(arrs,j,j+1);
				}
				k++;
			}
		}
		System.out.println("k = "+ k);
		return arrs;
	}
	
	private static void swap(int[] array ,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
