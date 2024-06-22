class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int fix = 0;
        int r = 0;
        int l = 0;
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];        
        for(int i = 0; i < nums.length-2; i++) {
            fix = i;
            r = nums.length-1;
            l = i+1;
            
            while(fix < l && r > l) {
                
                if(nums[fix] + nums[r] + nums[l] == target) {
                    return target;
                }
                else if(Math.abs(target - (nums[fix] + nums[r] + nums[l])) <=  Math.abs(target - res) ) {
                    res = nums[fix] + nums[r] + nums[l];
                } 
                if(nums[fix] + nums[r] + nums[l] < target) {
                    l++;
                } else {
                    r--;
                }
                
            }
        }
        
        return res;
    }
}