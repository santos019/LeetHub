class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int index = len-1;
        
        if(len == 1) return true;
        
        for(int i = 0; i <= index; i++) {
            if (i == index) {
                return true;
            }
            char ch = s.charAt(i);
            char ch2 = s.charAt(index);
            
            if(!Character.isLetterOrDigit(ch)) {
                continue;
            }
            
            if(!Character.isLetterOrDigit(ch2)) {
                index--;
                i--;
                continue;
            }
            
            if(Character.toLowerCase(ch) != Character.toLowerCase(ch2)) {
                return false;
            }
  
            if ((index - i == 2) ) {
                return true;
            }

            if (index - i == 1 && Character.toLowerCase(ch) == Character.toLowerCase(ch2)) {
                return true;
            }
  
            index--;
            if(index <= 0) return true;
        }
        
        return false;
    }
}