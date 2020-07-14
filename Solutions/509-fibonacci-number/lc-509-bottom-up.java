class Solution {
    public int fib(int N) {
        // bottom up solution
        
        if (N <=1 ) return N;
        
        int prev1 = 1;
        int prev2 = 0;
        int cur = -1;
        
        for(int i = N - 1; i > 0; i--) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        
        return cur;
    }
}