class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // convert wordList to set for fast checking
        Set<String> unvisited = new HashSet<>();
        for (String word : wordList) {
            // there is no need to revisit beginWord
            if (!word.equals(beginWord)) {
                unvisited.add(word);
            }
        }

        // BFS to construct a graph from beginWord to endWord
        // a node's valid children (in word list && previously unvisited)
        Map<String, List<String>> children = new HashMap<>();
        // Queue to store nodes to be visited in the next level
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        boolean found = false;
        // stop BFS either when queue is empty or endWord is found
        while (!queue.isEmpty() && !found) {
            // current visited nodes in this level
            // if same node is visited from multiple parents in one level
            // we need to record them all
            Set<String> curVisited = new HashSet<>();
            for (int i = queue.size(); i > 0; i--) {
                String word = queue.poll();
                // check curWord's every neighbor
                for (int j = 0; j < word.length(); j++) {
                    StringBuilder sb = new StringBuilder(word);
                    for (char k = 'a'; k <= 'z'; k++) {
                        sb.setCharAt(j, k);
                        String neighbor = sb.toString();
                        // in word list and hasn't been visited
                        if (unvisited.contains(neighbor)) {
                            List<String> list = children.getOrDefault(word, new ArrayList<String>());
                            list.add(neighbor);
                            children.put(word, list);
                            // avoid putting same node twice in the queue
                            if (!curVisited.contains(neighbor)) {
                                queue.offer(neighbor);
                            }
                            curVisited.add(neighbor);
                            // mark found if the endWord is found
                            if (neighbor.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                }
            }
            // remove words visited in this level
            unvisited.removeAll(curVisited);
        }
        List<List<String>> ans = new ArrayList<>();
        // not found, return empty list
        if (!found)
            return ans;
        List<String> curPath = new ArrayList<String>();
        curPath.add(beginWord);
        getPaths(beginWord, endWord, children, ans, curPath);

        return ans;
    }

    // DFS (backtracking) to get all possible paths
    void getPaths(String word, String endWord, Map<String, List<String>> children, List<List<String>> ans,
            List<String> curPath) {
        // base case, word is endWord
        if (word.equals(endWord)) {
            // must make a copy
            ans.add(new ArrayList(curPath));
            return;
        }

        List<String> childList = children.get(word);
        // childList chould be null
        if (childList == null)
            return;
        for (String child : childList) {
            curPath.add(child);
            getPaths(child, endWord, children, ans, curPath);
            // remove last element
            curPath.remove(curPath.size() - 1);
        }

        return;
    }
}