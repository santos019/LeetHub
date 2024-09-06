class Solution {
    public int climbStairs(int n) {
        int[]dp = new int[n+1];
        Arrays.fill(dp, -1);
        return findPath(n, dp);
    }

    public int findPath(final int n, final int[] dp) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) return dp[n];

        dp[n] = findPath(n-1, dp) + findPath(n-2, dp);

        return dp[n];
    }
}