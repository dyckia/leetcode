// Use HashMap instead of count Array if string contains unicode

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        
        HashMap<Character, Integer> mapS = countChar(s);
        HashMap<Character, Integer> mapT = countChar(t);


        return mapS.equals(mapT);
    }
    
    private HashMap<Character, Integer> countChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            int n = count.getOrDefault(s.charAt(i), 0);
            count.put(s.charAt(i), n + 1);
        }
        
        return count;
    }
}

/*
Time: n

Space: 1
*/