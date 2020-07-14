class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dp(s, set, s.length(), memo);
    }
    
    // return all the possible sentences given a substring(0, end)
    private List<String> dp(String s, Set<String> set, int end, Map<Integer, List<String>> memo) {
        // already in memory
        if (memo.containsKey(end)) return memo.get(end);
        
        List<String> res = new LinkedList<>();
        // special case left is (0, 0) and right is (0, end)
        if (set.contains(s.substring(0, end))) res.add(s.substring(0, end));
        
        for (int i = 1; i < end; i++) {
            String right = s.substring(i, end);
            // skip if right part is not in dict
            if (!set.contains(right)) continue;
            List<String> leftList = dp(s, set, i, memo);
            addToList(leftList, right, res);
            }
        
        memo.put(end, res);
        return res;
    }
    
    // append right to each element of leftList and add to res
    private void addToList(List<String> leftList, String right, List<String> res) {
        // if leftList is empty, that means left is impossible, do nothing
        
        for (String left : leftList) {
            StringBuilder sb = new StringBuilder(left);
            sb.append(' ');
            sb.append(right);
            res.add(sb.toString());
        }
        return;
    }
}

/*
Time: n*3
one for the split, one for check the prefix, one for the append

Space: n + m
one for memo, one for wordDict set
*/