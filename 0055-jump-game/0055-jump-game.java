class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int index = 0;
        int max = 0;

        if(len == 1) return true;
        
        for(int i = 0; i < len; i++) {
            max = Math.max(max, i + nums[i]);
            
            if(max >= len - 1) {
                return true;
            }

            if(max == i && index == i) return false;

            if(i == index) {
                index = max;
                max = 0;
            }

        }
        
        return false;
    }
}