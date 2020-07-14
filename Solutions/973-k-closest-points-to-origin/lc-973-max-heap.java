class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // maintain a max heap whose size is k
        // discard the largest if distCur < largest
        PriorityQueue<int[]> heap = new PriorityQueue<>(K, (a, b) -> (b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]));
        
        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > K) heap.poll();
        }
        
        int size = heap.size();
        
        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            res[i] = heap.poll();
        }
            
        return res;
    }
}