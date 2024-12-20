class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        final int sLen = s.length();
        boolean dp[] = new boolean [sLen + 1];
        dp[0] = true;

        for(int i = 0; i < sLen; i++) {
            for(int j = 1; i + j <= sLen; j++) {
                String tmp = s.substring(i, i + j);
                if(dp[i] && set.contains(tmp)) {
                    dp[i+j] = true;
                }
            }
        }

        return dp[sLen];
    }
}