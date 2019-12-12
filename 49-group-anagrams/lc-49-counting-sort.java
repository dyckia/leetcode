// if two words are anagrams
// their sorted strings must be equal
// as the number of characters is small, use counting sort

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, Integer> indMap = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            char[] sortedArr = countSort(arr);
            String key = String.valueOf(sortedArr);
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

    private char[] countSort(char[] input) {
        char[] output = new char[input.length];
        int[] index = new int[27];

        // count the occurrences of each char and shift right by 1
        for (char c : input) {
            index[c - 'a' + 1]++;
        }

        // compute cumulative sum
        for (int i = 1; i < index.length; i++) {
            index[i] = index[i] + index[i - 1];
        }

        // place char in output
        for (char c : input) {
            // get the index of current char in output array
            int ind = index[c - 'a']++;
            output[ind] = c;
        }

        return output;
    }
}

/*
Time: O(n * (K+26))
n is the length of array
K maximum string length in the array
For counting sort, the time complexity is O(a + b)
a is the length of array to be sorted
b is the range of the values in the array

Space: O(nK)
For counting sort, the space complexity is O(a + b)
a for the output array
b for storing the the index
*/