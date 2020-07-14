class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        if (needle.equals("")) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String substr = haystack.substring(i, i + needle.length());
            if (substr.equals(needle)) return i;
        }

        return -1;
    }
}