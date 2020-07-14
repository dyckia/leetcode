class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS to find the shortest path
        Queue<String> queue = new LinkedList<>();
        // HashSet constructor only accept Collections
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 1;
        
        while(!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String cur = queue.poll();
                // reach the endWord
                if (cur.equals(endWord)) return step;
                // add all its unvisited neighbor to the queue
                for (String word : wordList) {
                    if (visited.contains(word)) continue;
                    if (isNeighbor(cur, word)) {
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
            step++;
        }
        
        return 0;
    }
    
    private boolean isNeighbor(String w1, String w2) {
        // w1 and w2 have same length
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) diff++;
            // early stop
            if (diff > 1) return false;
        }
        return true;
    }
}