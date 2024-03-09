class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map <Character, Integer> tmp = new HashMap<>();
        int max = s.length() > 0 ? 1 : 0;
        int d = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tmp.containsKey(c) && tmp.get(c) >= d) d = tmp.get(c) + 1;

            if (d != i || tmp.containsKey(c)) {
                int tmpMax = i - d + 1;
                if(tmpMax > max) max = tmpMax;

            }
                tmp.put(c, i);

        }

        return max;


        
    }
}