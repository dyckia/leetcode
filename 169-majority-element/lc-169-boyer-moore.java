class Solution {
    public int majorityElement(int[] nums) {
        /*
        if we denote each occurance of majority element as 1
        and each occurance non-majority element as -1
        based on the assumption of the question
        the occurance sum must be greater than 0
        */
        int count = 0;
        int majority = -1;
        
        for (int num : nums) {
            if (count == 0) {
                majority = num;
            } 
            
            if (num == majority) {
                count++;
            } else {
                count--;
            }
        }
        
        return majority;
    }
}