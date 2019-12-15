class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        // lastWord -> index map
		// note there could be multiple phrases end with same word 
        Map<String, List<Integer>> endWith = new HashMap<>();
        // put entries in the map
        for (int i = 0; i < phrases.length; i++) {
            String[] words = phrases[i].split(" ");
            String endWord = words[words.length - 1];
            List<Integer> indList = endWith.getOrDefault(endWord, new ArrayList<Integer>());
            indList.add(i);
            endWith.put(endWord, indList);
        }
        // check the startWord in each phrase to see if there are phrases end with that same word
        Set<String> resSet = new HashSet<>();
        for (int i = 0; i < phrases.length; i++) {
            String[] words = phrases[i].split(" ");
            String startWord = words[0];
            // check if there is a phrase ends with startWord
            if (endWith.containsKey(startWord)) {
                List<Integer> indList = endWith.get(startWord);
                for (int ind : indList) {
                    // a phrase can not merge with itself
                    if (ind == i) continue;
                    // merge phrase ind with i
                    String firstStr = phrases[ind];
                    String secStr = phrases[i];
                    // we need cut before the space in the second string
                    int cutPoint = secStr.indexOf(" ");
                    // if secStr is just one word, there is no space
                    String secHalf = (cutPoint == -1) ? "" : secStr.substring(cutPoint);
                    resSet.add(firstStr + secHalf);
                }
            }
        }
        
		// create the list based on the HashSet, and sort lexicographically
        List<String> res = new ArrayList<>(resSet);
        Collections.sort(res);
        
        return res;
    }
}