class Solution {
    public int removeDuplicates(int[] nums) {
        int dex = 1;
        int tmp = nums[0];

        for(int k = 1; k <nums.length; k++) {
            if(tmp != nums[k]) {
                nums[dex] = nums[k];
                tmp = nums[dex];
                dex ++;
            }
        }

        return dex;
    }
}