/*
    The knows API is defined in the parent class Relation.
    boolean knows(int a, int b); 
*/

public class Solution extends Relation {
    /* 
        Find a candidate and check

        According to the definition: 
        if a knows b, a must not be a celebrity
        otherwise, b must not be a celebrity

        We can use the above condition
        compare current person with all person after him/her
        
        Since there is only one or zero celebrity, 
        one loop is enough to decide the candidate.

        After a candidate is found, we should double check
        with all the persons before him/her 
    */
    public int findCelebrity(int n) {
        int left = 0,
            right = n - 1;
        // find a possible candidate
        while (left < right) {
            // left could not be celebrity since he/she knows right
            if (knows(left, right)) left++;
            // otherwise right could not be celebrity since left does not know him/her
            else right--;
        }

        // our candidate is left (left == right)
        // check whether the candidate is an actual celebrity
        // by comparing it with all the numbers before him/her
        for (int i = 0; i < n; i++) {
            // should avoid i be candidate itself
            if (i != left && (knows(left, i) || !knows(i, left))) return -1;
        }

        return left;
    }
}

/*
Time: O(n)

Space: O(1)
*/