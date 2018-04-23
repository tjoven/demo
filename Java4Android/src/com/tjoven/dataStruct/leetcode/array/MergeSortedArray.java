package com.tjoven.dataStruct.leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {

/*	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3*/
	static int[] nums1 = {4,5,6,0,0,0};
	static int[] nums2 = {1,2,3}; 
	static int m = 3;
	static int n = 3;
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
		
        for (int i = 0; i < n; i++) {
        	
        	if(nums2[i]>=nums1[m-1]){
        		System.arraycopy(nums2, i, nums1, m+i,n-i);
        		return;
        	}
        	
        	for(int j = 0; j < m+i; j++){
        		if(smaller(nums2[i],nums1[j])){
    				//插入
        			 System.arraycopy(nums1, j, nums1, j+1, m-j);
        			 nums1[j] = nums2[i];
    				break;
    			}
        	}
        	
		}
    }
	
	private boolean smaller(int a,int b){
		return a<=b?true:false;
	}

}
