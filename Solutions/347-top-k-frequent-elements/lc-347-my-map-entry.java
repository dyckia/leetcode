class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        
        // count the occurrance of each unique number
        for (int n : nums) {
            int count = counts.getOrDefault(n, 0);
            counts.put(n, ++count);
        }
        
        // min-heap
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            heap.offer(entry);
            // pop the least element in the heap
            if (heap.size() > k) heap.poll();
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }
        
        return res;
    }
}