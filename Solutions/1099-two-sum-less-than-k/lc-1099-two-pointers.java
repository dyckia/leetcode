class Solution {
    // it is obvious that the order of i and j does not matter 
    // as long as i != j
    
    // use two pointers to find that maximum sum
    // we need to check till left == right
    
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        
        int left = 0,
            right = A.length - 1,
            maxSum = -1;
        
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum < K) {
                maxSum = Math.max(sum, maxSum);
                left++;
            } else {
                right--;
            }
        }
        
        return maxSum;
    }
}

/*
Time: O(nlogn)

Space: O(1)
*/