class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);
        Long checkRangeValueMax = 1L << 31;
        Long checkRangeValueMin = 1L >> 31;
        Long stayValue = 0L;
        String tmp = "";
        int last = 0;
        int stopIndex = x >= 0 ? 0 : 1; 
        for(int i = s.length() -1 ; i>= stopIndex; i--) {
            char c = s.charAt(i);
            tmp = tmp + c;
        }
        stayValue = Long.parseLong(tmp);
        if(stayValue >= checkRangeValueMax || stayValue <= checkRangeValueMin) return 0;
        last = Integer.parseInt(tmp);
        if (stopIndex == 1) last = last * -1;

        return last;
    }
}

// class Solution {
//     public int reverse(int x) {
//         int rev = 0;
//         int copy = Math.abs(1534236469);

//         while (copy > 0) {
//             int digit = copy % 10;
//             System.out.println("-------------------------------");

//             System.out.println("copy = " + copy);
//             System.out.println("digit = " + digit);
//             System.out.println("rev = " + rev);
//             System.out.println("(Integer.MAX_VALUE - digit) / 10 = " + (Integer.MAX_VALUE - digit) / 10);

//             if (rev > (Integer.MAX_VALUE - digit) / 10) {
//                 return 0;
//             }
//             System.out.println("rev = " + (rev * 10 + digit));
//             System.out.println("copy = " +  copy / 10);

//             rev = rev * 10 + digit;
//             copy = copy / 10;
//         }

//         if (x < 0) {
//             rev = -rev;
//         }

//         return rev;

        
        
//     }
// }