class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // for each step, we poll the smallest number in the matrix
        // that smallest number must be in the first row (priority queue)
        // because each colums is sorted in ascending order
        // for each poll, we replenish the heap by adding the next element in that column
        
        // since we need the index to add the next element we can create a dedicated object
        // to store such information
        
        // pass in comparator to avoid implementing comparable
        // PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        int n = matrix.length;
        
        // add all elements in the first row
        for (int i = 0; i < n; i++) {
            Node firstInRow = new Node(0, i, matrix[0][i]);
            minHeap.add(firstInRow);
        }
        
        Node cur = new Node(-1, -1, -1);
        for (int i = 1; i <= k; i++) {
            cur = minHeap.poll();
            // replenish if that element is not the last in the column
            if (cur.row < n-1) {
                Node nextInRow = new Node(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]);
                minHeap.add(nextInRow);
            }
        }
        return cur.val;
    }
    
    class Node implements Comparable<Node> {
        private int row;
        private int col;
        private int val;
        
        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
        
        @Override
        public int compareTo(Node that) {
            return this.val - that.val;
        }
    }
}

/*
Time: O(n + k*log(n))
Each add and poll takes log(n), total n + 2*k*log(n) actions.

Space: O(n)
For maintaining the heap.
*/