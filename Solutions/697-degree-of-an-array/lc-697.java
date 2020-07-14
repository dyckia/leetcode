class Solution {
    public int findShortestSubArray(int[] nums) {
        /* 
        if an array has degree of k, at least one of its elements occurs k times
        since we need to find a sub-array that also has a degree of k
        that subarray must span from the first occurance to the last occurance
        */
        
        // scan the arry:
        // record the first occurance of every element in left hashmap
        // record the last occurance of every element in right hashmap
        // count the frequence of every element in count hashmap
        
        HashMap<Integer, Integer> left = new HashMap<>(); //<element, index>
        HashMap<Integer, Integer> right = new HashMap<>(); //<element, index>
        HashMap<Integer, Integer> count = new HashMap<>(); //<element, count>
        
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (left.get(element) == null) {
                left.put(element, i);
            }
            right.put(element, i);
            count.put(element, count.getOrDefault(element, 0) + 1);
        }
        
        int minLength = Integer.MAX_VALUE;
        int degree = Collections.max(count.values());
        
        for (int element : count.keySet()) {
            if (count.get(element) == degree) {
                minLength = Math.min(minLength, right.get(element) - left.get(element) +1);
            }
        }
        
        return minLength;
    }
}