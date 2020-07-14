class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // problem is equivalent to find the smallest number i between matrixMin and matrixMax
        // that the count of elements in matrix that are smaller than i is k
        
        // i must be an element in the matrix
        // suppose i is not in the matrix, and j is the closest number to i in matrix
        // since count(element <= i) is k and i is not the matrix
        // count(element < i) must also be k
        // thus count(element <= j) is k, which contradicts that i is the smallest number
        
        // smallest number in the matrix is in the top left corner
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix.length-1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getCount(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left; 
    }
    
    // count the number of element in matrix which is less than or equal to guess
    private int getCount(int[][] matrix, int guess) {
        int count = 0;
        for (int i = 0; i < matrix.length && matrix[i][0] <= guess; i++) {
            for (int j = 0; j < matrix[0].length && matrix[i][j] <= guess; j++) {
                count++;
            }
        }

        return count;
        // a more clever way
        // if m[i][j+1] is the smallest number in column j that m[i][j] > k
        // then the column of that smallest number in row i+1 must be less than or equal to j
        
        // int count = 0
        // int j = matrix[0].length - 1;
        // for(int i = 0; i < matrix.length; i++) {
        //     while(j >= 0 && matrix[i][j] > mid) j--;
        //     count += (j + 1);
        // }
        
    }
}

/*
Time: O(n * log(n))
for each binary check we need to count at most n time

Space: O(1)

*/


