class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS to find the shortest path
        Queue<String> queue = new LinkedList<>();
        // HashSet constructor only accept Collections
        Set<String> visited = new HashSet<>();
        // HashSet for word list
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 1;
        
        while(!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String cur = queue.poll();
                // reach the endWord
                if (cur.equals(endWord)) return step;
                // check all current word's one step neighbor
                for (int j = 0; j < cur.length(); j++) {
                    StringBuilder sb = new StringBuilder(cur);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String neighbor = sb.toString();
                        // if not visited and in wordList add to queue
                        if (words.contains(neighbor) && !visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
            step++;
        }
        
        return 0;
    }
}