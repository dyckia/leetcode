class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = nextNum(n);
        }
        
        return n == 1;
    }
    
    private int nextNum(int n) {
        int sum = 0;
        
        while (n > 0) {
            int a = n % 10;
            n /= 10;
            sum += a * a;
        }
        
        return sum;
    }
}