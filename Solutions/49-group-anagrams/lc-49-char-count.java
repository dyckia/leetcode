// convert each string into a character count string
// abbeee -> #1#2#0#3#0...
// for fast comparison between strings use HashTable 

// convert each string into a character count string
// abbeee -> #1#2#0#3#0...
// for fast comparison between strings use HashTable 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String countString = getCountString(str);
            
            if (map.containsKey(countString)) {
                map.get(countString).add(str);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                map.put(countString, newList);
            }
        }

        return new ArrayList<>(map.values());
    }

    private String getCountString(String str) {
        int[] count = new int[26];

        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            sb.append('#');
            sb.append(count[i]);
        }

        return sb.toString();
    }
}

/*
Time: O(nK)
n is the length of array
K maximum string length in the array

Space: O(nK)
*/