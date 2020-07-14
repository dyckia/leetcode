class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // wordList set and visited set can be combined into one
        // words that haven't been visited
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        // create two sets respectively, one for begin search, one for end search
        // queue can be replaced by set
        Set<String> s1 = new HashSet<>();
        s1.add(beginWord);
        words.remove(beginWord);
        Set<String> s2 = new HashSet<>();
        s2.add(endWord);
        words.remove(endWord);
        // two steps: start and end
        int step = 2;
        
        while(!s1.isEmpty() && !s2.isEmpty()) {
            // optimization: instead alternate search s1 and s2
            // search the one whose size is smaller
            if (s1.size() > s2.size()) {
                Set<String> temp = s1;
                s1 = s2;
                s2 = temp;
            }
            // s1 is smaller
            // newSet must be created here not in the for loop!!!!!
            Set<String> newSet = new HashSet<>();
            for (String cur : s1) {
                // check all current word's one step neighbor
                for (int j = 0; j < cur.length(); j++) {
                    StringBuilder sb = new StringBuilder(cur);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String neighbor = sb.toString();
                        // two sets connected
                        if (s2.contains(neighbor)) return step;
                        // in words means hasn't been visited
                        if (words.contains(neighbor)) {
                            newSet.add(neighbor);
                            words.remove(neighbor);
                        }
                    }
                }
            }
            s1 = newSet;
            step++;
        }
        
        return 0;
    }
}

/*
Time: l * n
l is the length of the word
n is the size of wordList
for each neighbor check, time is 26 * l
worst case is that we need to visit all the words in the list 26 * m * n

Space: n
*/