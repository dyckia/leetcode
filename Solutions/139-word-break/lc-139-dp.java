class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] means substring(0, i) is breakable
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // check whether [0, j) and [j + 1, i) are both vaild words
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // don't need to check other break points
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}

/*
Time: n^2
for each dp[i] we need to check i times

Space: n
*/