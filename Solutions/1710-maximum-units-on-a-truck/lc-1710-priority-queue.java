class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Store every Integer is too slow
        // Use Arrays.asList to convert array to List (collections)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        pq.addAll(Arrays.asList(boxTypes));

        int res = 0;
        // must check if pq is empty
        while (!pq.isEmpty() && truckSize > 0) {
            int[] box = pq.poll();
            int boxCount = box[0];
            int unitCount = box[1];
            if (boxCount <= truckSize) {
                res += unitCount * boxCount;
            } else {
                res += unitCount * truckSize;
            }
            truckSize -= num;
        }

        return res;
    }
}