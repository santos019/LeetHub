class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;

        if(len == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for(int i = 1; i < len; i++) {
            int[] last = ans.get(ans.size() - 1);
            int[] current = intervals[i];

            if(last[1] >= current[0]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                ans.add(current);
            }
        }

        int[][] ansArray = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;      
    }
}