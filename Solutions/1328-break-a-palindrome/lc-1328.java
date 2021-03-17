class Solution {
    public String breakPalindrome(String palindrome) {
        /*  - If only one char, return ""
            - Check half of the string (the other half are the same)
            - Replace the first non 'a' char to 'a'
            - If not, replace the last char to 'b' (as the first char must be 'a')
        */
        int len = palindrome.length();
        if (len == 1) return "";
        
        StringBuilder newWordBuilder = new StringBuilder(palindrome);
        for (int i = 0; i < len / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                newWordBuilder.setCharAt(i, 'a');
                return newWordBuilder.toString();
            }
        }
        
        newWordBuilder.setCharAt(len - 1, 'b');
        return newWordBuilder.toString();
    }
}