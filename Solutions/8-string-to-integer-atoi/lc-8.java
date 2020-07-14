class Solution {
    public int myAtoi(String str) {
        // empty string
        if (str == null || str.length() == 0)
            return 0;
        
        // remove leading spaces
        int index = 0;
        int sign = 1;
        int res = 0;
        while (index < str.length() && str.charAt(index) == ' ') index++;
        
        // determine sign
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        
        // convert str to integer
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int lastDigit = str.charAt(index++) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && lastDigit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + lastDigit;
        }
        
        return res * sign;
    }
}