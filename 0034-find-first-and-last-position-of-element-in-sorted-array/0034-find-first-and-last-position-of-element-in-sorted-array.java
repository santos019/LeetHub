class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] ans = new int[2];
        ans[0] = findStart(nums, 0, len - 1, target, -1);
        ans[1] = findEnd(nums, 0, len - 1, target, -1);

        return ans;  
    }

    public int findStart(final int[] nums, final int left, final int right, final int target, final int foundIndex) {
        if(left > right) {
            return foundIndex;
        }

        int mid = (left + right) / 2;

        if(nums[mid] == target) {
            return findStart(nums, left, mid-1, target, mid);
        }
        if(nums[mid] < target) {
            return findStart(nums, mid+1, right, target, foundIndex);
        } else {
            return findStart(nums, left, mid-1, target, foundIndex);
        }
        
    }

        public int findEnd(final int[] nums, final int left, final int right, final int target, final int foundIndex) {
        if(left > right) {
            return foundIndex;
        }

        int mid = (left + right) / 2;

        if(nums[mid] == target) {
            return findEnd(nums, mid+1, right, target, mid);
        }
        if(nums[mid] < target) {
            return findEnd(nums, mid+1, right, target, foundIndex);
        } else {
            return findEnd(nums, left, mid-1, target, foundIndex);
        }

    }
}