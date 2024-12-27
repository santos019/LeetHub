class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int len = triangle.size();
        final int lastIndex_len = triangle.get(len - 1).size();
        final int[][] memo = new int[len][lastIndex_len];

        initMemo(memo);

        return calculateMinimun(triangle, 0, 0, memo);
    }

    private void initMemo(final int[][] memo) {
        for(int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
    }

    private int calculateMinimun(final List<List<Integer>> triangle, final int col, final int row, final int[][] memo) {
        if(col >= triangle.size()) {
            return 0;
        }

        if(hasMinimun(memo, row, col)) {
            return memo[row][col]; 
        }

        memo[row][col] = getCurrentMinimum(triangle, col, row, memo);

        return memo[row][col]; 
    }

    private boolean hasMinimun(final int[][] memo, final int row, final int col) {
        return memo[row][col] != Integer.MAX_VALUE;
    }

    private int getCurrentColMinimum(final List<List<Integer>> triangle, final int col, final int row) {
        return triangle.get(col).get(row);
    }

    private int getCurrentMinimum(final List<List<Integer>> triangle, final int col, final int row, final int[][] memo) {
        return getCurrentColMinimum(triangle, col, row) 
                                        + findMinimunBoth(triangle, col, row, memo);
    }

    private int findMinimunBoth(final List<List<Integer>> triangle, final int col, final int row, final int[][] memo) {
        return Math.min(calculateMinimun(triangle, col + 1, row, memo), 
                                            calculateMinimun(triangle, col + 1, row + 1, memo));
    }
}