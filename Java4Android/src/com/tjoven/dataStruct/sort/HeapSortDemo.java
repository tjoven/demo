package com.tjoven.dataStruct.sort;

import java.util.Arrays;


/**
 * 选择排序--堆排序
 * @author car
 *
 */
public class HeapSortDemo {

	static int[] is =  {9,7,6,5,4,8,3,2,1,4,2,8};
	public static void main(String[] args) {
		headSort(is);
		System.out.print(Arrays.toString(is));
	}
	
	private static void headSort(int[] array){
		int startIndex = array.length/2-1;
		for (int i = startIndex; i >= 0; i--) {
			heapAdjust(array, i,array.length-1);
		}
		
		for (int i = 0; i < array.length; i++) {
			swap(array,0 ,array.length-i-1);
			heapAdjust(array, 0, array.length-i-2);
		}
		
	}
	
	private static void swap(int[] array,int first,int second){
		int temp = array[second];
		array[second] = array[first];
		array[first]= temp;
	}
	private static void heapAdjust(int[] array,int index,int endIndex){
		
		while (2*index+1 <= endIndex) {
			int temp = array[index];
			int leftIndex = 2*index + 1;
			int rightIndex = 2*index+2;
			
			int biggerIndex = ((rightIndex <= endIndex) && (array[rightIndex] > array[leftIndex] )) ? rightIndex : leftIndex;
			
			if(array[index] >= array[biggerIndex]){
				break;
			}else{
				array[index] = array[biggerIndex];
				array[biggerIndex] = temp;
				index = biggerIndex;
			}
			
		}
		
	}

}
