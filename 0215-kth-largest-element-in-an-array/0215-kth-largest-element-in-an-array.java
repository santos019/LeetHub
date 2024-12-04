class Solution {
    public int findKthLargest(int[] nums, int k) {
        final int len = nums.length;

        for(int i = len/2 - 1; i >= 0 ; i--) {
            heapify(nums, i, len);
        }

        for(int i = 0; i < k; i++) {
            int tmp = nums[0];
            nums[0] = nums[len - i - 1];
            nums[len - i - 1] = tmp;

            heapify(nums, 0, len - i - 1);
        }

        return nums[len - k];
    }

    public void heapify(final int[] nums, final int root, final int stop) {
        int largest = root;
        int leftChild = root * 2 + 1;
        int rightChild = root * 2 + 2;

        if(stop > leftChild && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }

        if(stop > rightChild && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }

        if(root != largest) {
            int tmp = nums[root];
            nums[root] = nums[largest];
            nums[largest] = tmp; 

            heapify(nums, largest, stop);
        }
    }
}