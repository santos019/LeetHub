class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int cost = 0;
        int max = 0;
        int index = 0;

        for(int i = 0; i < len -1 ; i++) {
            max = Math.max(max, i + nums[i]);
            
            if(i == index) {
                cost++;
                index = max;
            }
            
        }
        
        return cost;   
    }
}
