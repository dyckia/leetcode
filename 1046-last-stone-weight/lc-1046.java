/*
PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return - Integer.compare(o1,o2);
        }
});

PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
    (Integer o1, Integer o2) -> (- Integer.compare(o1,o2))
);

PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
    Collections.reverseOrder()
);
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
                (Integer o1, Integer o2) -> (-Integer.compare(o1, o2)));

        for (int i : stones) {
            maxHeap.add(i);
        }

        while (maxHeap.size() > 1) {
            smash(maxHeap);
        }

        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }

    private void smash(PriorityQueue<Integer> maxHeap) {
        int s1 = maxHeap.poll();
        int s2 = maxHeap.poll();

        if (s1 != s2)
            maxHeap.add(Math.abs(s1 - s2));

        return;
    }
}