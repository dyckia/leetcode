// keep adding cur char to num until a non-digit char is found
// use stack to mimic the operation order
// for * and /, pop previous number and compute immediately
// for + and -, push number to stack and do the computation in the end

// keep adding cur char to num until a non-digit char is found
// use stack to mimic the operation order
// for * and /, pop previous number and compute immediately
// for + and -, push number to stack and do the computation in the end

class Solution {
    public int calculate(String s) {
        // null string
        if (s == null)
            return 0;

        int preNum = 0;
        int res = 0;
        char preOp = '+';

        for (int i = 0; i < s.length(); i++) {
            // skip space
            if (s.charAt(i) == ' ')
                continue;

            if (Character.isDigit(s.charAt(i))) {
                // parse number
                int curNum = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    curNum = curNum * 10 + (s.charAt(i++) - '0');
                }
                // update res
                if (preOp == '+') {
                    res += preNum;
                    preNum = curNum;
                } else if (preOp == '-') {
                    res += preNum;
                    preNum = -curNum;
                } else if (preOp == '*') {
                    preNum *= curNum;
                } else if (preOp == '/') {
                    preNum /= curNum;
                }
            } else {
                // must be a sign
                preOp = s.charAt(i++);
            }
            // back to prev index because of for loop
            i--;
        }

        return res + preNum;
    }
}