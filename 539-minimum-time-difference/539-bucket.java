// because the number of minutes is confirmed in a day
// we can save these time points in a boolean array instead
// the min difference will be the min distance between two true index

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] timeArr = convertToArray(timePoints);
        if (timeArr == null) return 0;

        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;
        Integer firstSeen = null;
        for (int i = 0; i < timeArr.length; i++) {
            if (!timeArr[i]) continue;
            if (prev != null) {
                int curDiff = i - prev;
                minDiff = Math.min(minDiff, curDiff);
            } else {
                firstSeen = i;
            }
            prev = i;
        }

        minDiff = Math.min(minDiff, 24 * 60 - prev + firstSeen);
        return minDiff;
    }

    // convert the time points to int array (minutes representation)
    boolean[] convertToArray(List<String> timePoints) {
        boolean[] arr = new boolean[24 * 60];
        for (String time : timePoints) {
            int ind = Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3, 5));
            // same time stamps, min diff is 0
            if (arr[ind]) return null;
            arr[ind] = true;
        }

        return arr;
    }
}