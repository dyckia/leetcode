class Solution {
    public int getSum(int a, int b) {
        // a and b could be negative
        // ensure that abs(a) >= abs(b)
        int x = Math.abs(a), y = Math.abs(b);
        if (x < y) return getSum(b, a);
        
        // determines the sign
        int sign = a > 0 ? 1 : -1;
        
        if (a * b > 0) {
            // sign * (x + y)
            // XOR is x + y without carry
            // carry = (x & y) << 1
            // keep XOR until carry equals 1
            while (y != 0) {
                int answer = x ^ y;
                int carry = (x & y) << 1;
                x = answer;
                y = carry;
            }
        } else {
            // sign * (x - y)
            // XOR is x - y without borrow
            // borrow = ((~x) & y) << 1
            // keep XOR until carry equals 1
            while (y != 0) {
                int answer = x ^ y;
                int borrow = ((~x) & y) << 1;
                x = answer;
                y = borrow;
            }
        }
        
        return sign * x;
    }
}

/*
Time: 1
since number in int is finite

Space: 1
*/