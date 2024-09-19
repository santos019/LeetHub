class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min = prices[0];
        int res = 0;

        for(int i = 0; i < len; i ++) {
            int target = prices[i];
            if(min > target) {
                min = target;
            } else if (target - min > res) {
                res = target- min;
            } 
        }
        
        return res;
    }
}