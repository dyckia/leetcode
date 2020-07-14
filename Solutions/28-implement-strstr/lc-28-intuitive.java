class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.equals("")) return 0;

        char[] hayArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        for (int i = 0; i < hayArr.length; i++) {
            if (compareWords(hayArr, i, needleArr)) return i;
        }
        return -1;
    }

    private boolean compareWords(char[] hayArr, int start, char[] needleArr) {
        for (int i = 0; i < needleArr.length; i++) {
            if (start + i >= hayArr.length || hayArr[start + i] != needleArr[i]) return false;
        }

        return true;
    }
}