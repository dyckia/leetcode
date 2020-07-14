class Solution {
    // A -> 1 * 26^0
    // AB -> 1 * 26^1 + 2

    public int titleToNumber(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            res *= 26;
            res += (s.charAt(i) - 'A' + 1);
        }
        
        return res;
    }
}

/*
Time: n

Space: 1
*/