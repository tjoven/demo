package com.tjoven.dataStruct.sort;

/**
 * 交换排序----快速排序
 * @author car
 *
 */
public class QuickSortDemo {
	
	static int[] is = {9,7,6,5,4,8,3,2,1,4,2,8};
	
	public static void main(String[] args) {
		play(is, 0, is.length-1);
		
		for (int i : is) {
			System.out.println(i);
		}
	}
	private static void play(int[] array, int start,int end) {
		// TODO Auto-generated method stub
		if(start>=end){
			return;
		}
		int pivotIndex = getPivotIndex(array, start, end);
		play(array, start, pivotIndex - 1);
		play(array, pivotIndex + 1,end);
	}
	
	private static int getPivotIndex(int[] array, int start,int end ) {
		// TODO Auto-generated method stub
		int pivot = array[start];
		int low = start +1 ;
		int height = end;
		
		while (height > low) {
			
			while (low<=height && array[low]<pivot) {
				low++;
			}
			
			while (low<=height && array[height]>pivot) {
				height--;
			}
			
			if(height > low){
				int temp = array[height];
				array[height] = array[low];
				array[low] = temp;
			}
		}
		
		while (array[height]>pivot && height>start) {
			height--;
		}
		
		if(height>start){
			array[start] = array[height];
			array[height] = pivot;
			return height;
		}else{
			return start;
		}
		
		
	}
}
