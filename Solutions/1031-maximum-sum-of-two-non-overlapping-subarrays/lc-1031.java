class Solution {
    // loop through the array
    // fix subarray M to be from i - m + 1 to i
    // at this given point, the max sum of the two subarraies must be lMax + mSum

    // since either L or M could occur before the other
    // we need to loop through the array twice

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Math.max(maxSum(A, L, M), maxSum(A, M, L));
    }

    // suppose firArray occurs before secArray 
    // return the max sum of two non-overlapping subarraies firArray and secArray
    // given their lengths firLen and secLen respectively 
    private int maxSum(int[] A, int firLen, int secLen) {
        int firMax = 0,  // the max sum of first array within range(0, i - secLen)
            firSum = 0,  // the sum of first array from i - secLen - firLen + 1  to i - secLen 
            secSum = 0,  // the sum of secondary array from i - secLen + 1 to i
            res = 0;

        for (int i = 0; i < A.length; i++) {
            secSum += A[i];

            // the length of sec array has exceeded secLen
            if (i >= secLen) {
                secSum -= A[i - secLen];
                firSum += A[i - secLen];
            }
            
            // the length of fir array has exceeded firLen
            if (i >= firLen + secLen) {
                firSum -= A[i - firLen - secLen];
            }

            // the length of fir array has reached firLen
            if (i >= firLen + secLen - 1) {
                firMax = Math.max(firSum, firMax);
                res = Math.max(res, firMax + secSum);
            }
        }

        return res;
    }
}