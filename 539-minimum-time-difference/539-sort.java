// convert time point to its minute representation
// save all time points in an array
// sort the array, then the minimum time difference points must be adjacent 
// treat the array as a circular array to compute the difference between the last and the first

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] timeArr = convertToArray(timePoints);
        Arrays.sort(timeArr);
        // the diff between the last one and the first one would be
        // first - (prev - 24 * 60)
        int prev = timeArr[timeArr.length - 1] - 24 * 60;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < timeArr.length; i++) {
            int cur = timeArr[i];
            int curDiff = cur - prev;
            minDiff = Math.min(minDiff, curDiff);
            prev = cur;
        }

        return minDiff;
    }

    // convert the time points to int array (minutes representation)
    int[] convertToArray(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        int i = 0;
        for (String time : timePoints) {
            arr[i] = Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3, 5));
            i++;
        }

        return arr;
    }
}