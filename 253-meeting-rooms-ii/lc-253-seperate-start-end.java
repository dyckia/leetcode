// When we encounter an ending event, that means that some meeting that started earlier has ended now. 
// We are not really concerned with which meeting has ended. 
// All we need is that some meeting ended thus making a room available.

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        // at least one room is needed
        int maxNum = 1;
        // i -> starts index, j -> ends index
        for (int i = 1, j = 0; i < len; i++) {
            if (ends[j] <= starts[i]) {
                // one meeting ended before this one starts
                // no more room is needed
                j++;
            } else {
                // needs more room at this moment
                maxNum++;
            }
        }
        
        return maxNum;
    }
}

/*
Time: nlogn

Space: n
*/