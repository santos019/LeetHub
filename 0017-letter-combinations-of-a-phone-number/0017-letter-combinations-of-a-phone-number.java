class Solution {
    private static final String[] MAPPINGS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        combine(digits, 0, "", ans);
        return ans;
    }
    
    private void combine(String digits, int index, String current, List<String> ans) {
        if (index == digits.length()) {
            ans.add(current);
            return;
        }
        
        String letters = MAPPINGS[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            combine(digits, index + 1, current + letter, ans); 
        }
    }
}