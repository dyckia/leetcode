class Solution {
    // A -> 1 * 26^0
    // AB -> 1 * 26^1 + 2
    public int titleToNumber(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            // we can use a base variable to aovid the pow calculation base *= 26
            int num = (s.charAt(len - 1 - i) - 'A' + 1) * (int) Math.pow(26, i);
            res += num;
        }
        
        return res;
    }
}

/*
Time: n

Space: 1
*/