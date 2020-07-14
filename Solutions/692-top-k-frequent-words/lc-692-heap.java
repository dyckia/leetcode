class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // <word, count>
        Map<String, Integer> counts = new HashMap<>();
        
        for (String word : words) {
            int count = counts.getOrDefault(word, 0);
            // must be ++count
            counts.put(word, ++count);
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (counts.get(a) != counts.get(b)) return counts.get(a) - counts.get(b);
            // same counts, lower first
            return b.compareTo(a);
        });
        
        for (String str : counts.keySet()) {
            minHeap.offer(str);
            if (minHeap.size() > k) minHeap.poll();
        }
        
        List<String> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        
        Collections.reverse(res);
        return res;
    }
}

/*
Time: nlogk
k is the size of the heap

Space: n
HashMap
*/