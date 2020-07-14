// use char subtraction '1' - '0' = 1

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0,
            i = a.length() - 1,
            j = b.length() - 1;

        while (i >=0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += (a.charAt(i--) - '0');
            if (j >= 0) sum += (b.charAt(j--) - '0');

            carry = sum / 2;
            sum = sum % 2;
            
            if (sum == 0) sb.append('0');
            else sb.append('1');

            // or
            // sb.append((char)(sum + '0'));
            
            // or
            // sb.append(sum);
        }

        return sb.reverse().toString();
    }
}