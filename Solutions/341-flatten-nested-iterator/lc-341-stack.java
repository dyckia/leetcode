/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */

import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        // flatten the list when initialized
        // use recursive call to flatten the list
        stack = new ArrayDeque();
        // push nestedInteger in reverse order
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
        getNextInteger();
    }

    // make sure the first element in the stack is alwasy an integer
    private void getNextInteger() {
        while (!stack.isEmpty() || !stack.peek().isInteger()) {
            // first element is a list
            List<NestedInteger> nestedList = stack.pop().getList();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }
        return;
    }

    @Override
    public Integer next() {
        // according to Java specs, interator should throw a NoSuchElementException
        // if there is no next element
        if (!hasNext()) throw new NoSuchElementException();
        // after an integer is used, find the next integer
        Integer ans = stack.pop().getInteger();
        getNextInteger();
        return ans;
    }

    @Override
    public boolean hasNext() {
        // first element in the stack must be an integer
        return stack.isEmpty() ? false : true;
    }
}


/*



Follow-up
Instead of reverse the list and push every element in a single step, 
we can get next number iteratively by using two stacks. 
On stack to store the current index of the element in each list
Another stack to store the List<NestedInteger> itself
*/