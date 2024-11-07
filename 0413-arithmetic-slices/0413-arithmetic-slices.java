class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int currentCount = 0;
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                currentCount += 1;
                count += currentCount;
            } else {
                currentCount = 0;
            }
        }
        
        return count;
    }
}
