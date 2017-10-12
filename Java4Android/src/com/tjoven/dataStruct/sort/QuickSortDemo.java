package com.tjoven.dataStruct.sort;

/**
 * 交换排序----快速排序
 * @author car
 *
 */
public class QuickSortDemo {
	static int[] array = {9,7,6,5,4,8,3,2,1,4,2,8};
	
	public static void main(String[] args) {
		quickSort(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	private static void quickSort(int[] array,int low,int height){
		if(low >= height){
			return;
		}
		int index = getPivotIndex(array, low, height);
		quickSort(array, low, index-1);
		quickSort(array, index+1, height);
	}
	
	private static int getPivotIndex(int[] array,int low,int height){
		int stand = array[low];
		
		while (low < height) {
			
			while (array[height] >= stand && low < height) {
				height--;
			}
			array[low] = array[height];
			
			while (array[low] <= stand && low < height) {
				low++;
			}
			array[height] = array[low];
			
		}
		array[low] = stand;
		
		return low;
		
	}
}
