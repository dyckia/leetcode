class Solution {
    public String addStrings(String num1, String num2) {
        int ind1 = num1.length() - 1,
            ind2 = num2.length() - 1,
            carry = 0;
        
        StringBuilder sb = new StringBuilder();
        while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
            int sum = carry;
            if (ind1 >= 0) sum += num1.charAt(ind1--) - '0';
            if (ind2 >= 0) sum += num2.charAt(ind2--) - '0';

            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
        }

        return sb.reverse().toString();
    }
}

remember to reverse the string