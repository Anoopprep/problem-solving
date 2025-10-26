/*
 * 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * prices = [7,1,5,3,6,4], ouput: 5
 * prices = [4,3,2,1], output: 0
 */

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int[] maxProfitArray = new int[prices.length];
        int res = 0;
        int max = prices[prices.length - 1];
        for(int i = prices.length - 1; i >= 0 ; i--) {
            if(prices[i] > max) max = prices[i];
            maxProfitArray[i] = max;
        }

        for(int i = 0; i < prices.length; i++) {
            int profit = maxProfitArray[i] - prices[i];
            if(profit > res) res = profit;
        }
        return res;
    }
}
