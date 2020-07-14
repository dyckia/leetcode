class Solution {
    public List<Integer> partitionLabels(String S) {
        /*
        "abdabe"
        1) if we include 'a' (index 0) in the our segment then that segement at least stretches to the last 'a' (index 3)
        2) check in the segment from 0 to 3 to see if there is any other char whose last char's index is greater than 3
        3) if not that segment is self-contained, compute its length
        */
        
        // scan from right to left to store every char's last index
        Map<Character, Integer> inds = new HashMap<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            // early stop
            if (inds.size() == 26) break;
            if (!inds.containsKey(S.charAt(i))) inds.put(S.charAt(i), i);
        }
        
        int start = 0;
        int end = inds.get(S.charAt(0));
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (i == end) {
                // segment is self contained
                res.add(end - start + 1);
                // boundary check before update start and end
                if (i < S.length() - 1) {
                    start = i + 1;
                    end = inds.get(S.charAt(i + 1));
                }
            } else {
                // current char's end position is within the segment
                if (inds.get(S.charAt(i)) <= end) continue;
                // update end otherwise
                end = inds.get(S.charAt(i));
            }
        }
        
        return res;
    }
}

/*
Time: n

Space: 1
*/