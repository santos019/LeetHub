class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int k = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                k = i; 
                break;
            }
        }
        
    
        if(len == 1) {
            if(nums[len-1] == target) return 0;
            else return -1;
        }

       if (target >= nums[k] && target <= nums[len - 1]) {
            return find(nums, k, len -1, target);
        } else {
            return find(nums, 0, k-1, target);
        }
        
    }
    
    public int find(final int[] nums, final int left, final int right, final int target) {
        if(left < 0 || right < left) {
            return -1;
        }

        int mid = (left + right)/2;
        if(nums[mid] == target) {
            return mid;
        }
        
        if(nums[mid] < target) {
            return find(nums, mid + 1, right, target);
        } else {
            return find(nums, left, mid-1, target);
        }
    }
}