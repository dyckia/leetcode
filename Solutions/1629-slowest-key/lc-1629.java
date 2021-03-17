class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0];
        char slowestKey = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {
            int curDuration = releaseTimes[i] - releaseTimes[i - 1];
            if (curDuration > maxDuration) {
                maxDuration = curDuration;
                slowestKey = keysPressed.charAt(i);
            } else if (curDuration == maxDuration) {
                slowestKey = (keysPressed.charAt(i) > slowestKey) ? keysPressed.charAt(i) : slowestKey;
            }
        }

        return slowestKey;
    }
}