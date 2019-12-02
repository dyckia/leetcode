class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        addToMap(map);
        int res = 0;
        int prev = -1;
        // start from right to left, if cur < prev, substract
        for (int i = s.length() - 1; i >= 0; i--) {
            int val = map.get(s.charAt[i]);
            if (val < prev) res -= val;
            else res += val;
            prev = val;
        }
        return res;
    }

    private void addToMap(Map<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return;
    }
}