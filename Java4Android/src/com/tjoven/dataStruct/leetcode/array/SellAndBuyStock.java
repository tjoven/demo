package com.tjoven.dataStruct.leetcode.array;

public class SellAndBuyStock {

	private int maxProfit(int[] prices){
		
	if(prices==null || prices.length <=1){
        return 0;
    }
    int topIndex = 0;
    int bottomIndex = 0;
    int profit = 0;
    for(int i=1;i<prices.length-1;i++){
        if(prices[i-1]<prices[i] && prices[i] > prices[i+1]){
            topIndex = i;
        }else if(prices[i] < prices[i+1] && prices[i] < prices[i-1]){
            bottomIndex = i;
        }
        if(bottomIndex < topIndex && bottomIndex > -1 && topIndex > -1){
            profit+=(prices[topIndex]-prices[bottomIndex]);
            bottomIndex = -1;
            topIndex = -1;
        }
        
        if(prices[1] > prices[0]){
            profit+=(prices[1]-prices[0]);
        }
        if(prices[prices.length-1] > prices[prices.length-2] && prices.length>2){
            profit+=(prices[prices.length-1]-prices[prices.length-2]);
        }
    }
    return profit;
	}
}
