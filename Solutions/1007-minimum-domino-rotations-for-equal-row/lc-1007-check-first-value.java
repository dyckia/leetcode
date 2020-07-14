import java.lang.Math;

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        // if we can eventually achieve equal row
        // that equal number must be in every domino
        // either it's on A side or B side
        
        int n = A.length;
        
        int equalA = checkEqualRow(A[0], A, B, n);
        // no need to check B[0]
        // if equalA != -1 && equalB != -1, then equalA == equalB
        if (A[0] == B[0] || equalA != -1) {
            return equalA;
        } else {
            return checkEqualRow(B[0], A, B, n);
        }
        
    }
    
    private int checkEqualRow(int num, int[] A, int[] B, int len) {
        // rotations needed for all A side to be nums
        int rotA = 0,
            rotB = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] != num && B[i] != num) {
                return -1;
            } else if (A[i] != num) {
                // B[i] == num && A[i] != num
                rotA++;
            } else if (B[i] != num) {
                rotB++;
            }
        }
        return Math.min(rotA, rotB);
    }
    
}

/*
Time: O(n)

Space: O(1)
*/