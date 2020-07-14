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
        int candidate = 0;
        // find a possible candidate
        for (int i = 1; i < n; i++) {
            // candidate could not be celebrity since he/she know i
            if (knows(candidate, i)) candidate = i;
            // otherwise i could not be a potential candidate since candidate does not know him/her
        }

        // check whether the candidate is an actual celebrity
        // by comparing it with all the numbers before him/her
        for (int i = 0; i < n; i++) {
            // should avoid i be candidate itself
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }

        return candidate;
    }
}

/*
Time: O(n)

Space: O(1)
*/