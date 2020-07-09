class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // memo[i] is true if s.substring(i, len) is true
        // Use boxing type Boolean so initial value is null
        Boolean[] memo = new Boolean[s.length() + 1];
        // s.substring(len, len) is always true
        memo[s.length()] = true;
        return backtracking(s, new HashSet<String>(wordDict), 0, memo);
    }
    
    private boolean backtracking(String s, HashSet<String> set, int start, Boolean[] memo) {
        if (memo[start] != null) return memo[start];
        
        // check every length of the word
        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end)) && backtracking(s, set, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        
        memo[start] = false;
        return false;
    }
}