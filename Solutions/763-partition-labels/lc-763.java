class Solution {
    public List<Integer> partitionLabels(String S) {
        /*
        "abdabe"
        1) if we include 'a' (index 0) in the our segment then that segement at least stretches to the last 'a' (index 3)
        2) check in the segment from 0 to 3 to see if there is any other char whose last char's index is greater than 3
        3) if not that segment is self-contained, compute its length
        */
        
        // scan to store every char's last index
        int[] inds = new int[26];
        for (int i = 0; i < S.length(); i++) {
            inds[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, inds[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return res;
    }
}

/*
Time: n

Space: 1
*/