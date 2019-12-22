/*
a valid IPv4 address consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        // store the index of dots to be inserted
        List<Integer> dots = new ArrayList<>();
        // first pos is 0
        dots.add(0);
        backtracking(dots, s, res);
        return res;
    }

    private void backtracking(List<Integer> dots, String s, List<String> res) {
        if (dots.size() == 4) {
            if (!isValidSegment(dots.get(3), s.length(), s)) return;
            // all three dots are inserted and last segment is valid, add valid IP to res
            String validIP = insertDots(dots, s);
            res.add(validIP);
            return;
        }

        int prevPos = dots.get(dots.size() - 1);
        // insert dots at every valid position
        for (int i = prevPos + 1; i < s.length(); i++) {
            // if current segment is already not valid, there is no need to loop further
            if (!isValidSegment(prevPos, i, s)) break;            
            dots.add(i);
            backtracking(dots, s, res);
            // remove previously added dot
            dots.remove(dots.size() - 1);
        }
        return;
    }

    private String insertDots(List<Integer> dots, String s) {
        // insert dots backwards so that the index won't change for the preceding dots
        StringBuilder sb = new StringBuilder(s);
        // skip first dot at 0
        for (int i = dots.size() - 1; i >= 1; i--) {
            // manually convert Integer to int to prevent from autoboxing
            sb.insert(dots.get(i).intValue(), '.');
        }
        return sb.toString();
    }

    // check if segment [start, end) is a valid segment
    private boolean isValidSegment(int start, int end, String s) {
        // for long numbers
        if (end - start > 3) return false;
        
        // no leading 0 and value is less than or equal to 255
        return ((end - start == 1) || s.charAt(start) != '0') && (Integer.valueOf(s.substring(start, end)) <= 255);
    }
}