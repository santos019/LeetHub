class Solution {
    public String convert(String s, int numRows) {
        String [] arr = new String[numRows];
        int lastIndex = numRows - 1;
        String ans = "";

        if (numRows == 1) return s;
        for (int i = 0; i < arr.length; i++) {
           arr[i] = "";
        }
        for(int c = 0, i = 0; c < s.length(); c++, i++) {
            char ch = s.charAt(c);

            if (i >= numRows) {
                arr[2*lastIndex - i] = arr[2*lastIndex - i] + ch;
            } else {
                arr[i] = arr[i] + ch;
            }

            if((2*numRows - 3) == i) {
                i = -1;
            }    
        }

        for(int k =0 ; k < numRows; k++) {
            ans = ans + arr[k];
        }

        return ans;
    }
}