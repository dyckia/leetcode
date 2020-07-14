class Solution {
    // read only => no sorting, no change sign
    // O(1) space => no HashSet
    
    // since len is n + 1 and all values is in between [1, n]
    // it is safe to treat value as the next index

    // we start from nums[0]
    // for every value there could be two scenarios:
    // that number is a new number we haven't seen before -> keep searching
    // that number we have already seen -> trapped in a cycle

    // since nums[0] already takes a number between 1 to n
    // and there are n slots left, there must exist at least
    // one duplicate number

    // the problem is similar to find the cycle in a LinkedList
    // use Floyd's Tortoise and Hare for cycle cycle detection
    
    public int findDuplicate(int[] nums) {
        // phase one - use slow and fast pointer to detect cycle
        // and find meet point
        int slow = nums[0],
            fast = nums[0];
        // we need to use do while loop since slow == fast at the beginning
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // phase two - reset fast pointer to nums[0] 
        // and adjust its speed to 1
        // find that cycle entrance
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

/*
Time: O(n)

Space: O(1)
*/