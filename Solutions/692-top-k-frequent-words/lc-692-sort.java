class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // <word, count>
        Map<String, Integer> counts = new HashMap<>();
        
        for (String word : words) {
            int count = counts.getOrDefault(word, 0);
            // must be ++count
            counts.put(word, ++count);
        }

        // keySet contains all the unique words
        // convert set to list
        List<String> candidates = new ArrayList<>(counts.keySet());

        Collections.sort(candidates, (a, b) -> {
            if (counts.get(a) != counts.get(b)) return counts.get(b) - counts.get(a);
            return a.compareTo(b);
        });

        // list1.sublist(start, end)
        return candidates.subList(0, k);
    }
}

/*
Time: nlogn

Space: n
HashMap
*/