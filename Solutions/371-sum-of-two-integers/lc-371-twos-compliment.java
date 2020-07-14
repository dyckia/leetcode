class Solution {
    public int getSum(int a, int b) {
        // in java, integer is stored in two's complement form
        // thus the additon of two signed numbers can be treated as unsigned numbers
        
        while (b != 0) {
            int answer = a ^ b;
            int carry = (a & b) << 1;
            a = answer;
            b = carry;
        }
        
        return a;
    }
}

/*
Time: 1
since number in int is finite

Space: 1
*/