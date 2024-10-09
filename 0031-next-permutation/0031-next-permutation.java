class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int spot = -1;
        
        if(len == 1) return;
        
        int current = nums[len - 1];
        int min = current;
        for(int i = len-2; i > -1; i--) {
            int before = nums[i];
            if(current > before) {
                spot = i;
                break;
            }
            current = before;
        }
        
        if(spot == -1) {
            reverse(nums, 0 , len -1);
            return;
        }
        
        for(int j = len -1; j > -1; j--) {
            if(nums[j] > nums[spot]) {
                int changedNum = nums[spot];
                nums[spot] = nums[j];
                nums[j] = changedNum;
                break;
            }
        }
        Arrays.sort(nums, spot + 1, len);

        return;
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}