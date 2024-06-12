class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int len = (int)Math.log10(x) + 1;
        int first = 0;
        int second = 0;
        for(int i = 0; i < len/2 ; i ++) {
            first = i > 0 ? x/(int)Math.pow(10, len-i-1)%(int)Math.pow(10, 1) : x/(int)Math.pow(10, len-i-1);
            second = x%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);            
            if(first != second) return false;
        }
        return true;
    }
}