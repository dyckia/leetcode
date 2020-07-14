// append each character into its corresponding row

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        
        int step = -1;
        int num = 0;
        for (char c : s.toCharArray()) {
            rows[num].append(c);
            if (num == 0 || num == numRows - 1) step *= -1;
            num += step;
        }

        StringBuilder sb = rows[0];
        for (int i = 1; i < rows.length; i++) {
            sb.append(rows[i]);
        }

        return sb.toString();
    }
}