class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap();
        char ch = s.charAt(0);
        char curCh = ' ';
        int res = 0;
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        res = romanMap.get(ch);

        for(int i=1; i<s.length(); i++) {
            curCh = s.charAt(i);
            if(romanMap.get(ch) >= romanMap.get(curCh)) {
                res = res + romanMap.get(curCh);
            } else {
                res = res + (romanMap.get(curCh) - romanMap.get(ch) * 2);
            }
            ch = curCh;
        }

        return res;
    }
}