class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // exculde 1 and n
        int count = n - 2;
        
        // only need to check to sqrt(n) as the rest pairs are equivalent to previous pairs 
        for (int i = 2; i * i < n; i++) {
            // not prime, its multiples have already been checked
            if (!isPrime[i]) continue;
            // start from i since previous pairs have been checked
            for (int j = i; i * j < n; j++) {
                if (isPrime[i * j]) {
                    isPrime[i * j] = false;
                    count--;
                }
            }
        }
        
        return count;
    }

    /*
    Time: n^2

    Space: n
    */
}