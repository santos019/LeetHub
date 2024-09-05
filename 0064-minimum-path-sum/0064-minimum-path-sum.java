class Solution {
    public int minPathSum(int[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        int min = 0;
        int[][] dp = new int[xLen][yLen];
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i < yLen; i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1]; 
        }
        
        for(int j = 1; j < xLen; j++) {
            dp[j][0] = grid[j][0] + dp[j-1][0];
        }
        
        for(int k = 0; k < xLen-1; k++) {
            for(int w = 0; w < yLen-1; w++) {
                min = dp[k][w+1] > dp[k+1][w] ? dp[k+1][w] : dp[k][w+1];
                dp[k+1][w+1] = grid[k+1][w+1] + min;
            }
        }
        
        return dp[xLen-1][yLen-1];
    }
    
}