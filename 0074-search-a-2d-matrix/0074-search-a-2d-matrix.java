class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][col -1]) {
                return findTarget(matrix[i], target, 0, col-1);
            }
        }

        return false;
    }

    public boolean findTarget(final int[] matrix, final int target, final int left, final int right) {
        if(left < 0 || right >= matrix.length) {
            return false;
        }

        int mid = (left+right)/2;
        
        if(target == matrix[mid]) {
            return true;
        }

        if(right <= left) {
            return false;
        }

        if(target < matrix[mid]) {
            return findTarget(matrix, target, left, mid);
        } else if(target > matrix[mid]) {
            return findTarget(matrix, target, mid + 1, right);
        } 
        
        return false;
    }
}