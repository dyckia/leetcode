// keep adding cur char to HashMap char -> index
// if cur char already exists in the map, start point is max(map.get(curChar), start)
// then overwrtie the index in map with cur index

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxL = 0;

        Map<Character, Integer> indMap = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            if (indMap.containsKey(s.charAt(end))) {
                // start index is the greater one in the indexInMap + 1 and start
                start = Math.max(indMap.get(s.charAt(end)) + 1, start);
            }
            maxL = Math.max(maxL, end - start + 1);
            indMap.put(s.charAt(end), end);
        }

        return maxL;
    }
}