class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        
        // sort the intervals list based on the start val of each intervals
        
        // lamda comparator
        // Arrays.sort(intervals, (intervalOne, intervalTwo) -> intervalOne[0] - intervalTwo[0]);
        
        // new comparator
        Comparator<int[]> myComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] intervalOne, int[] intervalTwo) {
                return intervalOne[0] - intervalTwo[0];
            }
        };
        
        Arrays.sort(intervals, myComparator);
        
        
        List<int[]> results = new ArrayList<>();
        
        int[] newInterval = intervals[0];
        int[] curInterval;
        
        for (int i = 1; i < intervals.length; i++) {
            curInterval = intervals[i];
            if (curInterval[0] <= newInterval[1]) {
                // there is an overlap
                newInterval[1] = Math.max(newInterval[1], curInterval[1]);
            } else {
                // no overlap
                results.add(newInterval);
                newInterval = curInterval;
            }
        }
        
        // add last one
        results.add(newInterval);
        
        int[][] resultsArray = results.toArray(new int[results.size()][]);
        
        return resultsArray;
    }
}