// if we know all valid parenthesis of n - 1 pairs
// the n pairs would just be with another extra ()
// we can use a memo to avoid duplicated computation

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
            return res;
        }

        for (int i = 0; i < n; i++) {
            for (String left : generateParenthesis(i)) {
                for (String right : generateParenthesis(n - 1 - i)) {
                    res.add("(" + left + ")" + right);
                }
            }
        }

        return res;
    }
}
