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
	private static void headSort(int[] is) {
		int len = is.length;
		// 构建最大堆
		for(int i = len/2;i>0;i--){
			adajust(is,i,len-1);
		}
		
		for(int i = len-1;i>=0;i--){
			swap(is,0,i);//把 最大数放在末尾
			//调整最大堆
			adajust(is,0,i-1);
		}
	}
	
	/**
	 * 
	 * @param is  数组
	 * @param index	  二叉树最小值
	 * @param length 二叉树最大值
	 */
	private static void adajust(int[] is, int index, int max) {
		// TODO Auto-generated method stub
		while(2*index+1 <= max){
			int temp = is[index];
			int left = 2 * index+1;
			int right = left + 1;
			int biggerIndex = (right>max||is[left] >is[right]) ? left : right;
			if(temp > is[biggerIndex]){
				break;
			}
			is[index] = is[biggerIndex];
			is[biggerIndex] = temp;
			index = biggerIndex;
		}
		
	}
	
	private static void swap(int[] array ,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
