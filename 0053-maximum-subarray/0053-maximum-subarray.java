class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tmpMax = max;

        for(int i = 1; i < nums.length; i++) {
            tmpMax = Math.max(nums[i], tmpMax + nums[i]);
            max = Math.max(max, tmpMax);
        }

        return max;
    }
}