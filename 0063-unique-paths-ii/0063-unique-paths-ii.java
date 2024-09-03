class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lastXIndex = obstacleGrid.length - 1;
        int lastYIndex = obstacleGrid[0].length - 1;
        int[][] dp = new int[lastXIndex + 1][lastYIndex + 1];
        boolean isSingleCellGrid = (lastXIndex == 0 && lastYIndex == 0) ? true : false;

        if(isSingleCellGrid) {
            return validateSingleCellGrid(obstacleGrid);
        }

        findUniquePath(lastXIndex, lastYIndex, 0, 0, dp, obstacleGrid);
        
        return dp[0][0];
    }

    public int validateSingleCellGrid(final int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 0) {
            return 1;
        }
    
        return 0;
    }

    public int findUniquePath(final int lastXIndex, final int lastYIndex, final int x, final int y, final int[][] dp, final int[][] obstacleGrid) {
        if (obstacleGrid[x][y] == 1) {
            return 0;
        }

        if (dp[x][y] > 0) {
            return dp[x][y];
        }

        if (x == lastXIndex && y == lastYIndex) {
            return 1;
        }

        int path = 0;

        if (x < lastXIndex) { 
            path = findUniquePath(lastXIndex, lastYIndex, x + 1, y, dp, obstacleGrid) + path;
        }

        if (y < lastYIndex) {
            path = findUniquePath(lastXIndex, lastYIndex, x, y + 1, dp, obstacleGrid) + path;
        }

        dp[x][y] = path;

        return path;
    }
}
