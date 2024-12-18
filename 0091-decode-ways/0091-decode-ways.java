class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0 || s.charAt(0) == '0') return 0;
        if(len == 1) return 1;
        int[] dp = new int[len + 1];

        dp[0] = 1;
        dp[1] = s.charAt(1) == '0' ? 0 : 1;

        for(int i = 2; i <= len; i++) {
            if(s.charAt(i - 1) != '0') {
                dp[i] = dp[i] + dp[i-1]; 
            }

            int value = Integer.parseInt(s.substring(i - 2, i));
            if(value > 9 && value < 27) {
                dp[i] = dp[i] + dp[i-2];
            }
        }

        return dp[len];
    }
}