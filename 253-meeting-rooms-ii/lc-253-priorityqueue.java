class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // insert meetings based on their starting time
        // use PriorityQueue to check if any meeting ended
        // check size of PriorityQueue after each insertion
        
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((i1, i2) -> (i1[1] - i2[1]));
        int num = 0;
        
        for (int[] interval : intervals) {
            // some meetings have ended before new meeting starts
            while(!queue.isEmpty() && queue.peek()[1] <= interval[0]) {
                queue.poll();
            }
            queue.offer(interval);
            num = Math.max(num, queue.size());
        }
        
        return num;
    }
}

/*
Time: nlogn

Space: n
*/