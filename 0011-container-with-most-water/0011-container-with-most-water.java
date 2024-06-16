class Solution {
    public int maxArea(int[] height) {
        int max = height.length;
        int l = 0;
        int r = max - 1;
        int res = 0;
        int tmp = 0;
        while(l < r) {
            tmp = (r - l) * (height[r] > height[l] ? height[l] : height[r]);    
            res = tmp > res ? tmp : res;
            if(height[r] > height[l]) l++;
            else r--;
        }

        return res;
    }
}