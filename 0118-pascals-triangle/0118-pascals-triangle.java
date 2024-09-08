class Solution {
    public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> dp = new ArrayList<>();
    dp.add(new ArrayList<>(List.of(1)));
    
    for(int i = 1; i < numRows; i ++ ) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        for(int j = 1; j < i; j ++) {
            int value = dp.get(i-1).get(j - 1);
            int value2 = dp.get(i-1).get(j);
            tmp.add(value + value2);
        }
        tmp.add(1);
        dp.add(tmp);
    }

        return dp;
    }
}
