class Solution {
    public int searchInsert(int[] nums, int target) {
        int mem = nums[0];

        if (mem > target) return 0;
        
        for(int i = 0; i < nums.length; i ++) {
            if(target == nums[i]) {
                return i;
            }
            
            if(mem < target &&  target <nums[i]) {
                return i;
            }
            
            mem = nums[i];
        }
        
        return nums.length;
    }
}