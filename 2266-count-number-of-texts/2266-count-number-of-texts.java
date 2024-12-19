class Solution {
    public int countTexts(String pressedKeys) {
        final int MOD = 1000_000_007;
        final int len = pressedKeys.length();
        if(len == 1) return 1;
        
        int[] dp = new int[len + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= len; i++) {
            dp[i] = dp[i-1] % MOD;
            char prevChar = pressedKeys.charAt(i-1); 

            if(canFirstStep(pressedKeys, i)) {
                dp[i] = (dp[i] + dp[i-2]) % MOD;    
            }
            
            if(canSecondStep(pressedKeys, i)) {
                dp[i] = (dp[i] + dp[i-3]) % MOD;          
            }
            
            if(canThirdStep(pressedKeys, i)) {
                dp[i] = (dp[i] + dp[i-4]) % MOD;          
            }
            
        }
        
        return dp[len];
    }

    private boolean canFirstStep(final String pressedKeys, final int index) {
        if(index >= 2 && pressedKeys.charAt(index-1) == pressedKeys.charAt(index-2)) {
            return true;
        }

        return false;
    }

    private boolean canSecondStep(final String pressedKeys, final int index) {
        if(index >= 3 && pressedKeys.charAt(index-1) == pressedKeys.charAt(index-2) 
               && pressedKeys.charAt(index-2) == pressedKeys.charAt(index-3)) {
            return true;
        }

        return false;
    }

    private boolean canThirdStep(final String pressedKeys, final int index) {
        if(index >= 4 && isSevenOrNine(pressedKeys.charAt(index-1)) && pressedKeys.charAt(index-1) == pressedKeys.charAt(index-2) 
               && pressedKeys.charAt(index-2) == pressedKeys.charAt(index-3)
              && pressedKeys.charAt(index-3) == pressedKeys.charAt(index-4)) {
            return true;
        }

        return false;
    }

    private boolean isSevenOrNine(final char c){
        if(c == '7' || c == '9') {
            return true;
        }

        return false;
    }
}