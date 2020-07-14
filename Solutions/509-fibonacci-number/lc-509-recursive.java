class Solution {
    public int fib(int N) {
        //resursive approach
        
        if (N == 0 || N == 1) return N;
        
        return fib(N - 1) + fib (N - 2);
    }
}

/* 
Time: O(2^n)
Space: O(n) stack call