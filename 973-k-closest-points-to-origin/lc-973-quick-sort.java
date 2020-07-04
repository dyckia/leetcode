class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int l = 0;
        int r = points.length - 1;
        
        // keep quick sorting until first K numbers are all smaller than pivot
        while (l < r) {
            int pos = getPivotPos(points, l, r);
            if (pos == K) break;
            if (pos > K) r = pos - 1;
            else l = pos + 1;
        }
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int getPivotPos(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l < r) {
            while (l < r && compareDist(points[r], pivot) >= 0) r--;
            points[l] = points[r];
            while (l < r && compareDist(points[l], pivot) <= 0) l++;
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }
    
    private int compareDist(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}