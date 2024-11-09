class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int totalSum = 0;
        int target = 0;
        
        for(int num : nums) {
            totalSum = totalSum + num;
        }
        
        if (totalSum%2 != 0) {
            return false;
        }
        
        target = totalSum/2;
        
        boolean[] partitionBook = new boolean[target + 1];
        partitionBook[0] = true;
        
        for(int num : nums) {
            for(int i = target; i >= num; i--) {
                partitionBook[i] = partitionBook[i] || partitionBook[i - num];
            }
        }
    
        return partitionBook[target];
    }
}