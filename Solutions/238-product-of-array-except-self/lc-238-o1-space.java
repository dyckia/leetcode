class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // left product array
        int[] result = new int[nums.length];
        result[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        
        int right = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            right = right * nums[i+1];
            result[i] = right * result[i];
        }
        
        return result;
    }
}