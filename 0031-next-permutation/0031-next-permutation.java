class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;

        int targetIndex = getTargetIndex(nums, len);
        tryGetNextPermutation(targetIndex, nums, len);

    }

    private int getTargetIndex(int[] nums, final int len) {
        int beforeValue = nums[len-1];

        for(int i = len - 2; i >= 0; i--) {
            if(nums[i] >= beforeValue) {
                beforeValue = nums[i];
                continue;
            }

            if(nums[i] < beforeValue) {
                return i;
            }
        }

        return -1;
    }

    private void tryGetNextPermutation (final int targetIndex, int[] nums, final int len) {
        if(targetIndex == -1) {
            canNotGetNextPermutation(nums);
        }

        if(targetIndex != -1) {
            canGetNextPermutation(targetIndex, nums, len);
        }

    }

    private void canNotGetNextPermutation(int[] nums) {
        Arrays.sort(nums);

    }

    private void canGetNextPermutation(final int targetIndex, int[] nums, final int len) {
        int min = nums[targetIndex + 1];
        int minIndex = getMinIndex(nums, targetIndex + 2, len, targetIndex, min);

        swap(nums, minIndex, targetIndex);
        Arrays.sort(nums, targetIndex + 1, len);

    }

    private int getMinIndex(int[] nums, final int startIndex, final int endIndex, final int targetIndex, int min) {
        int minIndex = targetIndex + 1;
        for(int i = startIndex; i < endIndex; i++) {
            if(min > nums[i] && nums[i] > nums[targetIndex]) {
                min = nums[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void swap(int[] nums, final int minIndex, final int targetIndex) {
        int tmp = nums[minIndex];
        nums[minIndex] = nums[targetIndex];
        nums[targetIndex] = tmp;

    }

}
