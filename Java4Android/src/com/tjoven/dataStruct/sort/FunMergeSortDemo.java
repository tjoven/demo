package com.tjoven.dataStruct.sort;

/**
 * 归并排序
 * @author car
 *
 */
public class FunMergeSortDemo {

	static int[] array1 = {1,3,5,7,9};
	static int[] array2 = {0,2,4,6,8,10,12};
	static int[] array = {0,2,1,4,3,8,7};
	
	public static void main(String[] args) {
		funMergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}
	
	private static void funMergeSort(int[] array){
		if (array.length == 1) {
			return;
		}
		int length = array.length;
		int length1 = length/2;	
		int length2 = length - length1;
		int[] array1 = new int[length1];
		int[] array2 = new int[length2];
		
		System.arraycopy(array, 0, array1, 0, length1);
		System.arraycopy(array, length1, array2, 0, length2);
		
		funMergeSort(array1);
		funMergeSort(array2);
		
		int[] datas = merge(array1, array2);
		System.arraycopy(datas, 0, array, 0, length);
	}
	private static int[] merge(int[] array1,int[] array2){
		int length1  = array1.length;
		int length2 = array2.length;
		int count1 = 0;
		int count2 = 0;
		int count = 0;
		
		int[] resultArr = new int[length1+length2];
		
		while (count1 < length1 && count2 < length2 ) {
			if (array1[count1]<array2[count2]) {
				resultArr[count] = array1[count1];
				count1++;
			}else {
				resultArr[count] = array2[count2];
				count2++;
			}
			count++;
		}
		
		while (count1<length1) {
			resultArr[count] = array1[count1];
			count++;
			count1++;
			
		}
		
		while (count2<length2) {
			resultArr[count] = array2[count2];
			count++;
			count2++;
			
		}
		return resultArr;
		
	}
}
