/*
a valid IPv4 address consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        // pick three seperator points i, j and k
        // [0, i) [i, j) [j, k) [k, end + 1)
        // each segment can at most have three chars
        for (int i = 1; i <= (len - 3) && i <= 3; i++) {
            for (int j = i + 1; j <= (len - 2) && j <= i + 3; j++) {
                for (int k = j + 1; k <= (len - 1) && k <= j + 3; k++) {
                    String seg1 = s.substring(0, i);
                    String seg2 = s.substring(i, j);
                    String seg3 = s.substring(j, k);
                    String seg4 = s.substring(k, len);
                    if (isValid(seg1) && isValid(seg2) && isValid(seg3) && isValid(seg4)) {
                        res.add(seg1 + '.' + seg2 + '.' + seg3 + '.' + seg4);
                    }
                }
            }
        }
        return res;
    }

    // return the string representation of segment if it is valid
    // return null otherwise (leading zeros or greater than 255)
    private boolean isValid(String seg) {
        // more than three digits
        if (seg.length() > 3) return false;
        // leading zero
        if (seg.length() != 1 && seg.charAt(0) == '0') return false;
        // less than 255
        return Integer.valueOf(seg) <= 255 ? true : false;
    }
}