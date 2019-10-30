class Solution {

    /*
     * we rotate the matrix layer by layer
     * 
     * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
     * 
     * 1 2 3 4 5 6 10 11 15 16 20 21 22 23 24 25
     * 
     * we start from (c, c) the cordinates of other three elements are (c, n - 1 -
     * c) (n - 1 - c, n - 1 - c) (n - 1 - c, c)
     * 
     * next element is (c, c + 1) the cordinates of other three elements are (c + 1,
     * n - 1 - c) (n - 1 - c, n - 1 - c - 1) (n - 1 - c - 1, c)
     * 
     * the end condition for this layer is when c + k == n - 1 - c
     */

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int layer = 0; layer <= n / 2 - 1; layer++) {
            int end = n - 1 - layer;
            for (int i = 0; i < end - layer; i++) {
                int temp = matrix[layer][layer + i];
                matrix[layer][layer + i] = matrix[end - i][layer];
                matrix[end - i][layer] = matrix[end][end - i];
                matrix[end][end - i] = matrix[layer + i][end];
                matrix[layer + i][end] = temp;
            }
        }

    }

}

/*
Time: O(n^2)

Space: O(1)
*/