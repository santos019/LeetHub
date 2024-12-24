class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal == 0 || maxChoosableInteger >= desiredTotal) {
            return true;
        }

        int totalSum = maxChoosableInteger * (maxChoosableInteger + 1) /2;

        if(totalSum < desiredTotal) {
            return false;
        }

        boolean[] usedNumber = new boolean[maxChoosableInteger + 1];
        Map<Integer, Boolean> memo = new HashMap<>();

        return can(maxChoosableInteger, desiredTotal, usedNumber, memo);
    }

    private boolean can(final int maxChoosableInteger, final int desiredTotal, final boolean[] usedNumber, Map<Integer, Boolean> memo) {
        if(desiredTotal <= 0) {
            return false;
        }

        int key = 0;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (usedNumber[i]) {
                key |= (1 << (i - 1));
            }
        }

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        for(int i = 1; i <= maxChoosableInteger; i++) {
            if(usedNumber[i]) {
                continue;
            }

            usedNumber[i] = true;

            if(!can(maxChoosableInteger, desiredTotal - i, usedNumber, memo)) {
                usedNumber[i] = false;
                memo.put(key, true);
                return true;
            }
            
            usedNumber[i] = false;
        }

        memo.put(key, false);
        return false;
    }
}