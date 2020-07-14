class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // put every possible prefix in the queue
        // number indicates the starting index of the rest substring
        Queue<Integer> prefixes = new LinkedList<>();
        // store if a previous prefix has been visited
        Set<Integer> visited = new HashSet<>();
        prefixes.offer(0);
        
        while (!prefixes.isEmpty()) {
            int start = prefixes.poll();
            // reaches the end
            if (start == s.length()) return true;
            for (int end = start + 1; end <= s.length(); end++) {
                // only add to queue if that prefix hasn't been visited
                if (set.contains(s.substring(start, end)) && !visited.contains(end)) {
                    prefixes.offer(end);
                    visited.add(end);
                }
            }
        }
        
        return false;
    }
}

/*
Time: n^2
for each dp[i] we need to check i times

Space: n
*/