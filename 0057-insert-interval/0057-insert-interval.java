class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans = new int[intervals.length + 1][];
        ans = Arrays.copyOf(intervals, intervals.length + 1);
        ans[intervals.length] = newInterval;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(ans, Comparator.comparingInt(a -> a[0]));
        res.add(ans[0]);

        for(int i = 1; i < ans.length; i++) {
            int[] prev = res.get(res.size() - 1);
            if(prev[1] >= ans[i][0]) {
                prev[1] = Math.max(prev[1], ans[i][1]);
            } else {
                res.add(ans[i]);
            }
        }

        int[][] ansArray = new int[res.size()][];
        for(int i = 0; i < res.size(); i++) {
            ansArray[i] = res.get(i);
        }
        
        return ansArray;
    }
}