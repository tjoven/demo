package com.tjoven.dataStruct.sort;


/**
 * 选择排序--堆排序
 * @author car
 *
 */
public class HeapSortDemo {

	static int[] is = {3,4,9,7,1,2,6,5,8,10};
	public static void main(String[] args) {

		//做堆 完全二叉树的样子
		for (int i = (is.length-1)/2; i >= 0; i--) {
			play(is, i, is.length);
		}
		
		for (int i : is) {
			System.out.println(i);
		}
		
		for (int i = is.length-1; i >0; i--) {
			exchange(is,i);
			play(is, 0, i);
		}
		
		System.out.println("------------");
		for (int i : is) {
			System.out.println(i);
		}
	}
	
	private static void exchange(int[] array,int index) {
		// TODO Auto-generated method stub
		int temp = array[0];
		array[0] = array[index];
		array[index] = temp;
		
	}

	/**
	 * 
	 * @param array 待排序的数组
	 * @param index 排序的根节点坐标
	 * @param length 要排序的长度
	 */
	private static void play(int[] array,int index,int length) {
		// TODO Auto-generated method stub
		
		while (2*index+1<length) {
			int biggerIndex;
			int temp = array[index];
			int leftIndex = 2*index+1;
			int rightIndex = 2*index+2;
			
			 if (rightIndex < length && array[leftIndex] < array[rightIndex]) {
				 biggerIndex = rightIndex;
			}else {
				biggerIndex = leftIndex;
			}
			 
			 if (temp>array[biggerIndex]) {
				break;
			}else {
				array[index] = array[biggerIndex];
			}
			 
			 index = biggerIndex;
			 array[biggerIndex] = temp;
		}
	}

}
