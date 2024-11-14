class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] pacificTracking = new int[heights.length][heights[0].length];
        int[][] atlanticTracking = new int[heights.length][heights[0].length];

        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> pacificOcean = new HashSet<>();
        Set<List<Integer>> atlanticOcean = new HashSet<>();
        
        for(int i = 0; i < heights.length; i++) {
            find(heights, i, 0, heights[i][0], pacificOcean, pacificTracking);
            find(heights, i, heights[0].length - 1, heights[i][heights[0].length - 1], atlanticOcean, atlanticTracking);
        }
        
        for(int i = 0; i < heights[0].length; i++) {
            find(heights, 0, i, heights[0][i], pacificOcean, pacificTracking);
            find(heights, heights.length - 1, i, heights[heights.length - 1][i], atlanticOcean, atlanticTracking);
        }
        
        for (List<Integer> cell : pacificOcean) {
            if (atlanticOcean.contains(cell)) {
                res.add(cell);
            }
        }
        
        return res;
    }
    
    public void find(final int[][] heights, final int row, final int col, final int prevValue, Set<List<Integer>> ocean, final int[][] tracking) {
        if(row < 0 || col < 0 || row > heights.length - 1 || col > heights[0].length - 1) {
            return;
        }
        
        if(tracking[row][col] == 1) {
            return;
        }
        
        if(prevValue > heights[row][col]) {
            return;
        }
        
        tracking[row][col] = 1;
        
        ocean.add(List.of(row, col));
        
        find(heights, row, col + 1, heights[row][col], ocean, tracking);
        find(heights, row + 1, col, heights[row][col], ocean, tracking);
        find(heights, row, col - 1, heights[row][col], ocean, tracking);
        find(heights, row - 1, col, heights[row][col], ocean, tracking);
    }
}