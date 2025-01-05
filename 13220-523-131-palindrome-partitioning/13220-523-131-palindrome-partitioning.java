class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        backtracking(s, 0, res, new ArrayList<>());

        return res;
    }

    public void backtracking(final String s, final int start, List<List<String>> res, List<String> tmp) {
        if(start == s.length()) {
            res.add(new ArrayList<>(tmp));
        }

        for(int end = start; end < s.length(); end++) {
            if(isPal(s, start, end)) {
                String str = s.substring(start, end+1);
                tmp.add(str);
                backtracking(s, end + 1, res, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public boolean isPal(final String s, int left, int right) {
        while(left < right) {
            char left_ch = s.charAt(left);
            char right_ch = s.charAt(right);
            if(left_ch != right_ch) {
                return false;
            }

            right--;
            left++;
        }

        return true;
    }
}