class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.empty()) return false;
                if(map.get(stack.peek()) != c ) {
                    return false;
                } 
                stack.pop();
            }

        }

        if(stack.empty()) return true;
        return false;

    }
}