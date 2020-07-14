import java.lang.Math;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    
    public int minDominoRotations(int[] A, int[] B) {
        // A[i] represents occurency of value i 
        int[] countA = new int[7],
              countB = new int[7];
        
        // count of value i same on both sides
        int[] countSame = new int[7];
        
        for (int i = 0; i < A.length; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i]) {
                countSame[A[i]]++;
            }
        }
        
        
        // if countA[i] + count B[i] - countSame[i] == length 
        // that means we can have one side all equal to i
        // rotation is length - max(countA, countB)
        for (int i = 1; i < 7; i++) {
            if (countA[i] + countB[i] - countSame[i] == A.length) return A.length - Math.max(countA[i], countB[i]);
        }
        
        return -1;
    }
    
}

/*
Time: O(n)

Space: O(1)
*/