class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix[0].length;
        int column = matrix.length;
        int size = row * column;
        int operator = 1;
        int x = -1;
        int y = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i < size; i++ ) {
            
            for(int r = 0; r < row; r++) {
                x = x + 1 * operator;
                res.add(matrix[y][x]);
            }

            if(res.size() == size) return res;

            column--;

            for(int c = 0; c < column; c++) {
                y = y + 1 * operator;
                res.add(matrix[y][x]);
            }

            if(res.size() == size) return res;
            
            row--;

            operator = operator * -1;
        }
        return res;
    }
}