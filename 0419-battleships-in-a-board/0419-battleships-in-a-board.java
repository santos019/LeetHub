class Solution {
    public int countBattleships(char[][] board) {
        int rowCount = board.length;
        int colCount = board[0].length;
        int[][] tracking = new int[rowCount][colCount];
        int count = 0;
        
        for(int row = 0; row < rowCount; row ++) {
            for(int col = 0; col < colCount; col ++) {
                count = countBattleships(board, row, col, tracking, count);
            }
        }
        
        return count;
    }
    
    public int countBattleships(final char[][] board, final int row, int col, final int tracking[][], int count) {
        if(row >= board.length || col >= board[0].length) {
            return count;
        }
        
        if(tracking[row][col] == 1) {
            return count;
        }
        
        tracking[row][col] = 1;
        
        if(board[row][col] == '.') {
            return count;
        }
        
        countBattleships(board, row + 1, col, tracking, count);
        
        countBattleships(board, row, col + 1, tracking, count);
        
        return count + 1;
    }
}