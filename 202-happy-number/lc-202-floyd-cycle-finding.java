class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = nextNum(slow);
            fast = nextNum(nextNum(fast));
        } while (slow != 1 && slow != fast);

        return slow == 1;
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