class Solution {
    public int trailingZeroes(int n) {
        // only 5*2 results in 0 -> find complete pairs of 2 and 5
        // number of factor 2 is always larger than number of factor 5
        // conlsider only number of factor 5
        int res = 0;
        // starts from first number, which is 5
        for (int i = 5; i <= n; i += 5) {
            int curCount = 0;
            int curNum = i;
            while (curNum % 5 == 0) {
                // is still divisbile by 5, such as 25
                curNum /= 5;
                curCount++;
            }
            res += curCount;
        }
        
        return res;
    }
}
/*
Time: n
At each step, while it might look like we do O(logn) operation to count the number of fives, 
it actually amortizes to O(1), because the vast majority of numbers checked only contain a single factor of 5. 
It can be proven that the total number of fives is less than 2 * n / 5

Space: 1
*/