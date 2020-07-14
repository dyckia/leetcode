class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        addMappings(map);
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // closed bracket
                if (stack.isEmpty() || map.get(c) != stack.pop()) return false;
            } else {
                // open bracket
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }

    private void addMappings(Map<Character, Character> map) {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
}