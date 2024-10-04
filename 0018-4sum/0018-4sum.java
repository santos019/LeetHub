class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int fix = 0;
        int fix_second = 0;
        int left = 0;
        int right = 0;
        long sum = 0;

        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            fix = i;
            
            for(int j = i+1; j < nums.length - 2; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) continue;
                fix_second = j;
                right = nums.length -1;
                left = j + 1;

                while(right > left && fix_second < left) {
                   sum = (long) nums[fix] + nums[fix_second] + nums[right] + nums[left];
                    if(sum == target) {
                        ans.add(List.of(nums[fix], nums[fix_second], nums[left], nums[right]));

                        while(right > left && nums[left] == nums[left+1]) left++;
                        while(right > left && nums[right] == nums[right-1]) right--;

                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left ++;
                    }
                }
            }
        }

        return ans;
    }
}