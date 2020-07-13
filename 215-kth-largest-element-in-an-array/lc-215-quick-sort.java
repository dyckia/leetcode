class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    // return the kth largest element
    private int quickSelect(int[] nums, int left, int right, int k) {
        // final index for the pivot (right most element)
        int ind = left;

        // random version
        // Random random = new Random();
        // swap(nums, left + random.nextInt(right - left + 1), right);

        // all the elements after index ind are greater than right
        // all the elements before index ind are less than or equal to left
        for (int i = left; i < right; i++) {
            if (nums[i] <= nums[right]) {
                swap(nums, i, ind);
                ind++;
            }
        }
        
        swap(nums, ind, right);

        // number of elements greater than nums[ind]
        int count = right - ind + 1;
        if (count > k) return quickSelect(nums, ind + 1, right, k);
        if (count < k) return quickSelect(nums, left, ind - 1, k - count);

        return nums[ind];
    }
    

    private void swap(int[] nums, int ind1, int ind2) {
        if (ind1 == ind2) return;
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }
}

/*
Time: O(n)
Each time we call quick select, we cut our search scope by half.
For each partition, we do n swap at most.
n + n/2 + n/4 + n/16 + ... = n + n = 2n

Space: O(log(n))
For the recursive call
*/
