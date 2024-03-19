class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return "";

        String longestPalindrome = "";
        
        //짝수테케: battad, aaaa
        for (int i = 0; i < len; i++) {
            //홀수
            String oddPalindrome = expandAroundCenter(s, i, i);
            //짝수
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (oddPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = oddPalindrome;
            }
            if (evenPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = evenPalindrome;
            }
        }
        
        return longestPalindrome;
    }
    
    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
