// choose every char in the String as the starting point
// extend rightward until we encounter a duplicated char
// use HashSet to store the char in cur substring

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxL = 0,
            start = 0,
            end = 0;

        Set<Character> charSet = new HashSet<>();

        while (start < s.length() && end < s.length()) {
            if (!charSet.contains(s.charAt(end))) {
                // keep extending and update maxL
                charSet.add(s.charAt(end));
                maxL = Math.max(maxL, end - start + 1);
                end++;
            } else {
                // change start point to the first char after duplicated char
                // remove chars in the set until there is no duplicates
                charSet.remove(s.charAt(start));
                start++;
            }
        }

        return maxL;
    }
}

/*
Time: O(2n)
In the worst case, each char will be visited twice, start and end

Space: O(m)
m is the charset size of the string
*/
