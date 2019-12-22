// indexes of chars in the top row are: i * (2 * numRows - 2)
// indexes of chars in the bottom row are: i * (2 * numRows - 2) + numRows - 1
// indexes of chars in the between row r are: i * (2 * numRows - 2) + r and (i + 1) * (2 * numRows - 2) - r
// i is cycle number

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder res = new StringBuilder();

        int cycleLen = 2 * numRows - 2;
        int cycleNum = s.length() / cycleLen + 1;
        
        // r is row number
        // c is cycle number
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < cycleNum; c++) {
                if (r == 0) {
                    // top row
                    int ind = c * cycleLen;
                    if (ind >= s.length()) break;
                    res.append(s.charAt(ind));
                } else if (r == numRows -1) {
                    // botom row
                    int ind = c * cycleLen + numRows - 1;
                    if (ind >= s.length()) break;
                    res.append(s.charAt(ind));
                } else {
                    // inbetween rows
                    int ind1 = c * cycleLen + r;
                    int ind2 = (c + 1) * cycleLen - r;
                    if (ind1 >= s.length()) break;
                    res.append(s.charAt(ind1));
                    if (ind2 >= s.length()) break;
                    res.append(s.charAt(ind2));
                }
            }
        }

        return res.toString();
    }
}