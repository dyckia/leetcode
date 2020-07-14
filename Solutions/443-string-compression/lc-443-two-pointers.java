class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        // next index to write
        int ind = 0;
        int slow = 0;
        while (slow < len) {
            int fast = slow;
            int count = 1;
            while (fast + 1 < len && chars[fast + 1] == chars[slow]) {
                fast++;
                count++;
            }
            // no matter how much count is, we always need to add cur character
            chars[ind] = chars[slow];
            ind++;
            if (count > 1){
                // mutiple letter
                char[] countInChars = String.valueOf(count).toCharArray();
                for (int i = 0; i < countInChars.length; i++) {
                    chars[ind] = countInChars[i];
                    ind++;
                }
            }
            slow = fast + 1;
        }
        // (ind - 1) is the last index, + 1 is the length
        return ind;
    }
}