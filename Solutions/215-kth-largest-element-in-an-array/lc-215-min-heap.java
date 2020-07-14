class Solution {
    public int findKthLargest(int[] nums, int k) {
        // use a min heap to store the largest k numbers we've seen so far
        // if the size of the heap is greater than k, poll the smallest number in the heap

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.poll();
    }
}

/*
Time: O(Nlogk)
for each offer / poll operation, the time complexity is logk where k is the size of the heap

Space: O(k)
*/