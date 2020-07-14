class Solution {
    
    public int fib(int N) {
        //resursive approach with memoization
        if (N <= 1) return N;
        
        int[] fibs = new int[N+1];
        fibs[0] = 0;
        fibs[1] = 1;
        
        return helper(N, fibs);
    }
    
    public int helper(int N, int[] fibs) {
        
        if (N > 1 && fibs[N] == 0) {
            // fibs(N) hasn't been computed
            fibs[N] = helper(N-1, fibs) + helper(N-2, fibs);
        }
        
        return fibs[N];
    }
}

/* 
Time: O(n)
Space: O(n) array
*/