package com.tjoven.dataStruct.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author car
 *
 */
public class FunMergeSortDemo2 {

	static int[] array = {5,2,1,4,3,8,7};
	
	public static void main(String[] args) {
		funMergeSort(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
		
	}
	
	private static void funMergeSort(int[] array,int start,int end){
		if(start == end){
			return;
		}
		int mid = (start + end )/2;
		funMergeSort(array,start,mid);
		funMergeSort(array,mid+1,end);
		merge(array,start,mid,end);
	
	}

	private static void merge(int[] array, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = start ;
		
		int[] temp = new int[array.length];
		while(i<=mid && j<=end){
			if(array[i] < array[j]){
				temp[k++] = array[i++];
			}else{
				temp[k++] = array[j++];
			}
		}
		
		while(i<=mid){
			temp[k++] = array[i++];
		}
		
		while(j<=end){
			temp[k++] = array[j++];
		}
		
		while(start <= end){
			array[start] = temp[start];
			start++;
		}
		System.out.println(Arrays.toString(array));
		
	}
}
