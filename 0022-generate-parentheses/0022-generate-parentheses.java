class Solution {
    public List<String> generateParenthesis(int n) {
        
        List <String> mem = new ArrayList<>();
        generate(n, n, "", mem);
        
        return mem;
        
    }
    
    public void generate(int left, int right, String result, List<String> mem) {
        if(left == 0 && right == 0) {
            mem.add(result);
            return;
        }
        
        if(left > 0) {
            generate(left - 1, right, result + "(", mem);
        }
        
        if(right > left) {
            generate(left, right - 1, result + ")", mem);
        }
    }
}