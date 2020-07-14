class Solution {
    public int leastInterval(char[] tasks, int n) {
        // use array to store the frequency of each char
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int intervals = 0;

        while (freq[25] > 0) {
            int indexIncycle = 0;
            // number of intervals in a cycle is n+1
            while (indexIncycle <= n) {
                // stop if there is no task left
                if (freq[25] == 0)
                    break;
                // if false add idles
                if (indexIncycle <= 25 && freq[25 - indexIncycle] > 0) {
                    freq[25 - indexIncycle]--;
                }

                indexIncycle++;
                intervals++;
            }
            Arrays.sort(freq);
        }

        return intervals;
    }
}

/*
Time: O(k * nlogn)
count freq O(n)
For each sorting O(nlogn), 
needs to do k times of sorting, where k is the highest frequency number

Space: O(26)
*/