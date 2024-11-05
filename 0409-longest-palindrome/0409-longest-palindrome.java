class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> book = new HashMap<>();
        int len = s.length();
        int count = 0;
        int isOddNumber = 0;
        
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            book.put(c, book.getOrDefault(c, 0) + 1);
        }
        
        for(Map.Entry<Character, Integer> entry : book.entrySet()) {
            int cost = entry.getValue()/2;
            
            count = count + cost;
            
            if(entry.getValue() % 2 != 0) {
                isOddNumber = 1;
            }
            
        }
        
        return count * 2 + isOddNumber;
    }
}