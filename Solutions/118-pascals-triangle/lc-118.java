class Solution {
    // for an element i in cur array
    // its value equals to prev[i - 1] + prev[i]
    // cur[0] and cur[len - 1] are 1

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        // prevRow can be avoided by using res.get(i - 1)
        List<Integer> prevRow = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) curRow.add(1);
                else curRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            res.add(curRow);
            prevRow = curRow;
        }

        return res;
    }
}

/*
Time: O(n^2)

Space: O(1)
*/