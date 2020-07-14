// Use HashMap instead of count Array if string contains unicode

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        
        int[] countS = countChar(s);
        int[] countT = countChar(t);
        return Arrays.equals(countS, countT);
    }
    
    private int[] countChar(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        return count;
    }
}

/*
Time: n

Space: 1
*/