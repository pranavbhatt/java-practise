package com.pranav.javagrok.problemsolving;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * @author pbhatt
 *
 */
public class StockPrice {
    public int maxProfit(int[] prices) {
        int maxProfit=0;        
        int minPrice=Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++){
            if(prices[i] > minPrice){
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }else{
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
