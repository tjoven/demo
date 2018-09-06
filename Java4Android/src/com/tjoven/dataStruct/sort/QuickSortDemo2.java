package com.tjoven.dataStruct.sort;

public class QuickSortDemo2 {

	static int[] array2 = {10,22,14,63,48,1,12};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result= quickSort(array2,0,array2.length-1);
		for (int i : result) {
			System.out.println(i);
		}
	}
	
	private static int[] quickSort(int[] arrs,int low,int high){
		if(low < high){
			int part = partation(arrs,low,high);
			quickSort(arrs,low,part-1);
			quickSort(arrs,part+1,high);
		}
		return arrs;
	}
	
	private static int partation(int[] arrs,int low,int high){
		int standard = arrs[low];
		while(low < high){
			while(high > low && arrs[high] >=standard){
				high--;
			}
			swap(arrs,high,low);
			
			while(high > low && arrs[low] <= standard){
				low++;
			}
			swap(arrs,high,low);
		}
		return low;
	}
	private static void swap(int[] array ,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
