class Solution {
    public boolean canPartition(int[] nums) {
        int cost = 0;
        int len = nums.length;

        for(int i = 0; i <len; i ++) {
            cost = cost + nums[i];        
        }

        if(cost%2 != 0) return false;
        
        return canMakeTarget(nums, cost/2);
    }

    public boolean canMakeTarget(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  

         for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        return dp[target];
    }
}