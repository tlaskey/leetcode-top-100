public class BuySellStock {
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
            int max = 0;
            for (int i = 0; i < prices.length; i++) {
                int currBuy = prices[i];
                for (int j = i + 1; j < prices.length; j++) {
                    max = (prices[j] - currBuy > max) ? prices[j] - currBuy : max;
                }
            }
            return max;
        }

        // Better solution O(n) time, O(1) space
        public int maxProfit2(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minPrice) minPrice = prices[i];
                else if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
            }
            return maxProfit;
        }
}