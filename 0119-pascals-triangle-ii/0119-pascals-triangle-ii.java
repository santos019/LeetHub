class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> dp = new ArrayList<>(List.of(1));
        
        for(int i = 0; i < rowIndex; i++) {
            List<Integer> newDp = new ArrayList<>(List.of(1));
            for(int j = 0; j < dp.size() - 1; j++) {
                int value = dp.get(j);
                int value_second = dp.get(j + 1);
                newDp.add(value + value_second);
            }
            newDp.add(1);
            dp = newDp;
        }
        
        return dp;
    }
}