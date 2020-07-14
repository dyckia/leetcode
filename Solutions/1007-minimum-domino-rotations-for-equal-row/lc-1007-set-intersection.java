import java.lang.Math;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    
    // take the intersection of all {A[i], B[i]} sets
    // if n == 0, impossible to have one side be equal
    // if n == 1, only one side can be equal
    // if n == 2, both sides can be equal
    // n > 2 => can not happen
    public int minDominoRotations(int[] A, int[] B) {
        // original set (1, 2, 3, 4, 5, 6)
        HashSet<Integer> intersection = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        int[] countA = new int[7],
              countB = new int[7];
        
        for (int i = 0; i < A.length; i++) {
            // intersection.retainAll(Arrays.asList(A[i], B[i]));  // Time O(m*n) since we need to check if contains in List
            intersection.retainAll(new HashSet<>(Arrays.asList(A[i], B[i])));  // Time O(m) since contains lookup is O(1)

            countA[A[i]]++;
            countB[B[i]]++;
        }
        
        for (int i : intersection) {
            // we can have one side be all i
            return A.length - Math.max(countA[i], countB[i]);
        }
        
        return -1;
    }
    
}

/*
Time: O(n)
For for loop O(n)
For retainAll O(6) 

Space: O(1)
*/