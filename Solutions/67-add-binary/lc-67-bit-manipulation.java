// use char subtraction '1' - '0' = 1

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0,
            sum = 0,
            i = a.length() - 1,
            j = b.length() - 1;

        while (i >=0 || j >= 0 || carry != 0) {
            int bit1 = (i >= 0) ? convertToInt(a.charAt(i--)) : 0;
            int bit2 = (j >= 0) ? convertToInt(b.charAt(j--)) : 0;

            sum = carry ^ bit1 ^ bit2;
            // if any two of the threee are 1, carry is 1
            carry = (carry & bit1) | (carry & bit2) | (bit1 & bit2);

            sb.append(sum);
        }

        return sb.reverse().toString();
    }

    private int convertToInt(char c) {
        return Integer.parseInt(String.valueOf(c));
    }
}