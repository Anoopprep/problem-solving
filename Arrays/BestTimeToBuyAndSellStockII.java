/*
 * 122. Best Time to Buy and Sell Stock II
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.
 * Find and return the maximum profit you can achieve.
 */

public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int maxPro=0, buy,i=0;
        while(i<prices.length-1) {
            if(prices[i]>=prices[i+1]) i++;
            else{
                buy = prices[i];
                while(i<prices.length-1 && prices[i]<prices[i+1]) i++;
                maxPro = maxPro + (prices[i]-buy);
                i++;
            }
        }
        return maxPro;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
