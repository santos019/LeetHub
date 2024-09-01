class Solution {
    public int uniquePaths(int m, int n) {
        int lastXIndex = n;
        int lastYIndex = m;
        int dp [][] = new int[n][m];
        
        return findPath(0, 0, n - 1, m - 1, dp);
    }
    
    public int findPath(final int x, final int y, final int lastXIndex, final int lastYIndex, int[][] dp) {
        if (dp[x][y] > 0) return dp[x][y];

        if(x == lastXIndex && y == lastYIndex) return 1;
        
        int ans = 0;

        if (x < lastXIndex) {
            ans = findPath(x + 1, y, lastXIndex, lastYIndex, dp) + ans;
        }
        
        if (y < lastYIndex) {
            ans = findPath(x, y + 1, lastXIndex, lastYIndex, dp) + ans;
        }
        
        dp[x][y] = ans;
        return ans;
    }
}
