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
		return firstBadVersion();
    }
	
	private static boolean isBadVersion(int n) {
		if(n>=3){
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
		if(isBadVersion((first+last)/2)){
			last = (first+last)/2;
		}else {
			first = (first+last)/2;
		}
		return firstBadVersion();
    }
	
}
