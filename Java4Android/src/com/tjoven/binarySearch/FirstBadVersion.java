package com.tjoven.binarySearch;

public class FirstBadVersion {

	static final int N = 11;
	static int first = 1;
	static int last = N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = firstBadVersion(N);
		System.out.print(result);
	}

	public static int firstBadVersion(int n) {
		first = 1;
		last = N;
		return firstBadVersion02();
    }
	
	private static boolean isBadVersion(int n) {
		if(n>=3.6){
			return true;
		}
		return false;
	}
	public static int firstBadVersion() {
		if(first>=last-1){
			if(isBadVersion(first)){
				return first;
			}
			return last;
		}
		//这里不能这么写 容易overflow
//		int mid = (first+last)/2;
		int mid = first + (last-first)/2;
		if(isBadVersion(mid)){
			last = (first+last)/2;
		}else {
			first = (first+last)/2;
		}
		return firstBadVersion();
    }
	
	/**
	 * 方法2 标准答案
	 * @return
	 */
	public static int firstBadVersion02() {
		while(first<last){
			int mid = first + (last-first)/2;
			if(isBadVersion(mid)){
				last = mid;
			}else {
				first =mid+1;
			}
		}
		
		return first;
	}
	
}
