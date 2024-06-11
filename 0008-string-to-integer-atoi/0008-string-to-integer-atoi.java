class Solution {
    public int myAtoi(String s) {
        int res = 0;
        boolean input = false;
        int operation = 1;
        int[] res_arr = new int[200];
        int tmp = 0;
        int x = 0;
        for(int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if(input && c == ' ') break;
            if(c == ' ') continue;
            if(!input && c == '-') {
                operation = operation * -1;
                input = true;
                continue;
            }
            if(!input && c == '+') {
                input = true;
                continue;
            }
            if(c > '9' || c < '0') break;

            res_arr[tmp++] = c - '0';      
            
            if(!input) input = true;
        }

        if(res_arr[0] == 0) {
            for(int k = 0; k < tmp; k++) {
                if(res_arr[k] != 0) {
                    x = k ;
                    break;
                }
            }
        }

        if(res_arr[x] == 0 ) return 0;

        if(tmp-x > 10) {
            if(operation == 1) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        if(tmp -x == 10 && res_arr[0] > 2) {
            if(operation == 1) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        
            for(int j = x; j <tmp; j ++) {
                res = res * 10 + res_arr[j];

                if(operation == 1) {
                    if((res * (int) Math.pow(10, (tmp - j - 1)) > (Integer.MAX_VALUE )) || (res * (int) Math.pow(10, (tmp - j - 1)) < 0)) return Integer.MAX_VALUE;
                } else {
                    if(((res * (int) Math.pow(10, (tmp - j - 1)) + 1) > ((Integer.MIN_VALUE + 1) * -1))
                    || ((res * (int) Math.pow(10, (tmp - j - 1)))) < 0 ) return Integer.MIN_VALUE;
                }

        }

        return res * operation;
    }
}