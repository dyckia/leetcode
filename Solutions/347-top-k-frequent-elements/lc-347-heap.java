class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        
        // count the occurrance of each unique number
        for (int n : nums) {
            int count = counts.getOrDefault(n, 0);
            counts.put(n, ++count);
        }
        
        // min-heap
        // lamda expression can use variables in the enclosing scope
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> counts.get(a) - counts.get(b));
        for (int n : counts.keySet()) {
            heap.offer(n);
            // pop the least element in the heap
            if (heap.size() > k) heap.poll();
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        
        return res;
    }
}

/*
Time: nlogk

Space: n + k
hashmap and heap
*/