class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        
        if (totalLength % 2 == 1) {
            return findKth(nums1, nums2, totalLength / 2 + 1);
        } else {
            return (findKth(nums1, nums2, totalLength / 2) + findKth(nums1, nums2, totalLength / 2 + 1)) / 2.0;
        }
    }
    
    private static double findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            if (index1 == m) {
                return nums2[index2 + k - 1];
            }
            if (index2 == n) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int newIndex1 = Math.min(index1 + k / 2, m) - 1;
            int newIndex2 = Math.min(index2 + k / 2, n) - 1;

            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
