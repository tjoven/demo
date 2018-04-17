package com.tjoven.binarySearch;

public class GuessGame {

	static int N = 10;
	static int target = 6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(guessNumber(N));
	}

	public static int guessNumber(int n) {
		int left = 1;
		int right = n;
		while(left<right){
			int mid = left+(right-left)/2;
			if(guess(mid)==1){
				right = mid;
			}else if(guess(mid)==-1){
				left = mid+1;
			}else{
				return mid;
			}
		}
		return left;
        
    }
	
	
	private static int guess(int n){
		if(n>target){
			return 1;
		}else if(n<target){
			return -1;
		}
		return 0;
	}
}
