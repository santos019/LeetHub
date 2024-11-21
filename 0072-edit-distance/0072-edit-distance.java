class Solution {
    public int minDistance(String word1, String word2) {
        int word1_len = word1.length();
        int word2_len = word2.length();
        int[][] dp = new int[word1_len + 1][word2_len + 1];
        
        for(int i = 1; i <= word1_len; i++) {
            dp[i][0] = i;
        }

        for(int j = 1; j <= word2_len; j++) {
            dp[0][j] = j; 
        }

        for(int i = 1; i <= word1_len; i++) {
            for(int j = 1; j <= word2_len; j++) {
                char charOfWord1 = word1.charAt(i-1);
                char charOfWord2 = word2.charAt(j-1);

                if(charOfWord1 == charOfWord2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(
                        Math.min(
                            dp[i][j-1],
                            dp[i-1][j-1]
                        ),
                        dp[i-1][j]
                    ) + 1;
                }
            }
        }

        return dp[word1_len][word2_len];
    }
}