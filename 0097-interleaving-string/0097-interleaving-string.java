class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        final int s1_len = s1.length();
        final int s2_len = s2.length();
        final int s3_len = s3.length();
        
        if(s1_len + s2_len != s3_len) {
            return false;
        }
        
        boolean dp[][] = new boolean[s1_len + 1][s2_len + 1];
        dp[0][0] = true;
        
        for(int i = 1; i <= s1_len; i++) {
            dp[i][0] = dp[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        
        for(int i = 1; i <= s2_len; i++) {
            dp[0][i] = dp[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
        }
        
        for(int i = 1; i <= s1_len; i++) {
            for(int j = 1; j <= s2_len; j++) {
                dp[i][j] = (dp[i][j-1] && (s3.charAt(i+j-1) == s2.charAt(j-1))) || 
                    (dp[i-1][j] && (s3.charAt(i+j-1) == s1.charAt(i-1)));
            }
        }
        
        return dp[s1_len][s2_len];
    }
}