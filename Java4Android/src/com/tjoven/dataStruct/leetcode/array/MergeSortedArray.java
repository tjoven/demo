package com.tjoven.dataStruct.leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {

/*	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3*/
	static int[] nums1 = {4,0,0,0};
	static int[] nums2 = {1,2}; 
	static int m = 1;
	static int n = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedArray demo = new MergeSortedArray();
		demo.merge(nums1, m, nums2, n);
		for(int a: nums1){
			System.out.println(a);
		}
	}
	
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(m<=0){
			System.arraycopy(nums2, 0, nums1, 0,n);
    		return;
		}
		int index = 0;//上次杀入的位置
        for (int i = 0; i < n; i++) {
        	
        	if(nums2[i]>=nums1[m+i-1]){//如果比nums1中最后一个数还大，就把nums2加到nums1后面
        		System.arraycopy(nums2, i, nums1, m+i,n-i);
        		return;
        	}
        	
        	for(int j = index; j < m+i; j++){
        		if(smaller(nums2[i],nums1[j])){
    				//插入
        			 System.arraycopy(nums1, j, nums1, j+1, m+i-j);
        			 nums1[j] = nums2[i];
        			 index = j;
    				break;
    			}
        	}
        	
		}
    }
	
	private boolean smaller(int a,int b){
		return a<=b?true:false;
	}

}
