class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(0, 0, n, "", res);
        return res;
    }

    private void backtracking(int open, int close, int n, String str, List<String> res) {
        // close must be less than or equal to open
        if (close == n) {
            res.add(str);
            return;
        }

        if (open < n) backtracking(open + 1, close, n, str + "(", res);

        if (close < open) backtracking(open, close + 1, n, str + ")", res);

        return;
    }
}