class Solution {
    public void moveZeroes(int[] nums) {
        // index of first zero element
        int firstZeroInd = 0;
        
        for (int cur = 0; cur < nums.length; cur++){
            // if cur element is non-zero, swap it with the first zero element
            // so that everything between firstZeroInd and cur will be zero
            if (nums[cur] != 0) {
                int temp = nums[cur];
                nums[cur] = nums[firstZeroInd];
                nums[firstZeroInd] = temp;
                firstZeroInd++;
            }
        }
         
    }
}

/*
This solution also applies to move curtain elements to the end while keeping the relative order.
eg. move any number smaller than 5 to the end, keeping other elements in relative order.
[1, 2, 3, 4,5,6,7,8,9,10]

After using this algorithm, it goes to [5,6,7,8,9,10,1,2,3,4], which also keeps relative order of numbers.
*/