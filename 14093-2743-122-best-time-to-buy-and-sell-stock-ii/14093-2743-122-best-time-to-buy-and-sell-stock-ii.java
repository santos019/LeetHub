class Solution {
    public int maxProfit(int[] prices) {
        final int len = prices.length;
        int[] hold = new int[len];
        int[] cash = new int[len];

        hold[0] = -prices[0];
        cash[0] = 0;

        for(int i = 1; i < len; i++) {
            hold[i] = Math.max(hold[i-1], cash[i-1] - prices[i]);
            cash[i] = Math.max(cash[i-1], hold[i-1] + prices[i]);
        }

        return cash[len-1];
    }
}