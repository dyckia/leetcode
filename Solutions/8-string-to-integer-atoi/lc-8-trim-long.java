class Solution {
    public int myAtoi(String str) {
        // null string
        if (str == null)
            return 0;

        // remove leading spaces
        str = str.trim();
        int index = 0;
        int sign = 1;
        long res = 0L;

        // determine sign
        if (str.length() > 0 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
            sign = str.charAt(0) == '-' ? -1 : 1;
            index++;
        }

        // convert str to integer
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            res = res * 10 + (str.charAt(index++) - '0');
            if (res > Integer.MAX_VALUE)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return (int) res * sign;
    }
}