//Solution of Leetcode problem 
// 121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
      // We record the max profit at every stages
        int maxp = 0;
      // try to buy in min price so buy price always be minimum
        int buy=prices[0];
        for (int i=1;i<=prices.length-1;i++)
        {
            buy = Math.min(buy, prices[i]);
            int prof = prices[i]-buy;
            maxp = Math.max(maxp,prof);
        }
        return maxp;
    }
}
