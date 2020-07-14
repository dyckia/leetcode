// convert all punctuations to space and split by space
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> freq = new HashMap<>();

        // we can also just use paragraph.toLowerCase().split("\\W+")
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        int maxCount = -1;
        String commonWord = "";
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                int count = freq.getOrDefault(word, 0) + 1;
                freq.put(word, count);
                if (count > maxCount) {
                    maxCount = count;
                    commonWord = word;
                }
            }
        }
        return commonWord;
    }
}