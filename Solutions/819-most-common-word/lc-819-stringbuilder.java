// keep building the word while char is a letter

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> freq = new HashMap<>();

        int maxCount = -1;
        String commonWord = "";
        StringBuilder sb = new StringBuilder();

        // make sure last word is recognized
        paragraph += " ";
        for (char curChar : paragraph.toCharArray()) {
            if (Character.isLetter(curChar)) {
                // keep building word
                sb.append(Character.toLowerCase(curChar));
            } else if (sb.length() != 0) {
                String word = sb.toString();
                // check if the word is banned
                if (!bannedSet.contains(word)) {
                    int newCount = freq.getOrDefault(word, 0) + 1;
                    freq.put(word, newCount);
                    if (newCount > maxCount) {
                        maxCount = newCount;
                        commonWord = word;
                    }
                }
                sb = new StringBuilder();
            }
            // else -> empty string do nothing
        }
        return commonWord;
    }
}