// use two pointers to validate
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0,
            end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            while (end > start && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            char c1 = Character.toLowerCase(s.charAt(start));
            char c2 = Character.toLowerCase(s.charAt(end));

            if (c1 != c2) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}