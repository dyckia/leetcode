// find the longest non-repeating substring ends at each char
// choose the longest among them
// use HashMap to locate the index of that character

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indMap = new HashMap<>();
        int maxL = 0;
        int startInd = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!indMap.containsKey(cur)) {
                // add to map and update maxL
                indMap.put(cur, i);
                int curLen = i - startInd + 1;
                maxL = Math.max(maxL, curLen);
            } else {
                // remove chars from startInd to the first occurrence of the repeated char
                // and reset startInd
                // no need to update maxL since curlength <= maxL
                int repetInd = indMap.get(cur);
                removeEntries(indMap, s, startInd, repetInd);
                startInd = repetInd + 1;
                indMap.put(cur, i);
            }
        }

        return maxL;
    }
    
    // remove entries in the HashMap from start to end index
    private void removeEntries(Map<Character, Integer> indMap, String s, int start, int end) {
        for (int i = start; i <= end; i++) {
            indMap.remove(s.charAt(i));
        }
        return;
    }
}


/*
Time: O(2n)
In the worst case, each char will be visited twice, start and end

Space: O(m)
m is the charset size of the string
*/
