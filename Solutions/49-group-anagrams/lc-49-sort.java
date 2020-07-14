// if two words are anagrams
// their sorted strings must be equal 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, Integer> indMap = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (indMap.containsKey(key)) {
                int ind = indMap.get(key);
                res.get(ind).add(str);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                res.add(newList);
                indMap.put(key, res.size() - 1);
            }
        }

        return res;
    }
}

/*
Time: O(n KlogK)
n is the length of array
K maximum string length in the array

Space: O(nK)
*/

/*
or store list directly in the map
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                map.put(key, newList);
            }
        }

        return new ArrayList<>(map.values());
    }
}
*/