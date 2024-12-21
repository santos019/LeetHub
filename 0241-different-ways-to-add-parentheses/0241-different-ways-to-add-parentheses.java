class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo = new HashMap<>();
    
        return getAWay(expression, memo);
    }
    
    public List<Integer> getAWay(final String expression, final Map<String, List<Integer>> memo) {
        if(expression.length() == 0) return List.of();

        if(memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> list = new ArrayList<>();
        boolean hasOperator = false;
        
        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                hasOperator = true;
                break;
            }
        }

        if (!hasOperator) {
            list.add(Integer.parseInt(expression));
            memo.put(expression, list);
            return list;
        }

        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if(!Character.isDigit(c)) {

                String left_str = expression.substring(0, i);
                String right_str = expression.substring(i + 1);
                List<Integer> left = getAWay(left_str, memo);
                List<Integer> right = getAWay(right_str, memo);
                
                for(int left_value : left) {
                    for(int right_value : right) {
                        if(c == '+') {
                            list.add(left_value + right_value);
                        } else if(c == '-') {
                            list.add(left_value - right_value);
                        } else if(c == '*') {
                            list.add(left_value * right_value);
                        }
                    }
                }
                                
            }
            
        }
        memo.put(expression, list);
        
        return list;
    }
}