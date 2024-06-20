class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set <String> noDuplicate = new HashSet();

        Arrays.sort(nums);
        int right = 0;
        int left = 0;
        int fix = 0;

        for(int i=0; i<nums.length - 2; i++) {
            fix = i;
            left  = i + 1;
            right = nums.length - 1;
            if(fix != 0 && nums[fix] == nums[fix - 1]) continue;
            while(right > left && fix < left) {
                if(nums[fix] + nums[right] + nums[left] > 0) {
                    right --;
                } else if (nums[fix] + nums[right] + nums[left] < 0 ) {
                    left ++;
                } else {
                    if(!noDuplicate.contains(nums[fix] + "/" + nums[left] + "/" + nums[right]))
                    {
                        res.add(List.of(nums[fix], nums[left], nums[right]));
                        noDuplicate.add(nums[fix] + "/" + nums[left] + "/" + nums[right]);
                    }
                    
                    right --;
                    left ++;
                }
            }

        } 
        return res;
    }
}