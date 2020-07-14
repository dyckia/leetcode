class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // by fixing one end, we can turn the problem into a binary search problem
        
        for (int i = 0; i < numbers.length - 1; i++) {
            int newTarget = target - numbers[i];
            int left = i+1;
            int right = numbers.length-1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (numbers[mid] < newTarget) {
                    left = mid+1;
                } else if (numbers[mid] > newTarget) {
                    right = mid-1;
                } else {
                    return new int[] {i+1, mid+1};
                }
            }
        }
        
        return new int[] {};
    }
}