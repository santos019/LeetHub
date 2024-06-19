class Solution {
    public String longestCommonPrefix(String[] strs) {
        char ch = ' ';
        String res = "";

        if(strs.length == 0) return "";

        for(int i = 0; i < strs[0].length(); i++) {
            ch = strs[0].charAt(i);
            for(int j = 1; j <strs.length; j++) {
                if(strs[j].length() <= i || strs[j].charAt(i) != ch) return res;
                
            }
            res = res + ch;
            
        }
        return res;
    }
}