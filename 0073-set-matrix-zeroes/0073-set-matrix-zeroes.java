class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> book = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != 0) {
                    continue;
                }

                book.add(new int[] {i, j});
            }
        }

        for(int i = 0; i < book.size(); i ++) {
            int[] coor = book.get(i);
            setCopy(matrix, coor[0], coor[1]);
        }
    }

    public void setCopy(int[][] copy, final int row, final int col) {
            for(int i = 0; i < copy.length; i ++) {
                if(copy[i][col] == 0) {
                    continue;
                }
                copy[i][col] = 0;
            }

            for(int j = 0; j < copy[0].length; j++) {
                if(copy[row][j] == 0) {
                    continue;
                }
                copy[row][j] = 0;
            }
    }
}