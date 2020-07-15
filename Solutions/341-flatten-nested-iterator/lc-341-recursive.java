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
    List<Integer> flatList;
    int pos;

    public NestedIterator(List<NestedInteger> nestedList) {
        // flatten the list when initialized
        // use recursive call to flatten the list
        flatList = new ArrayList<>();
        pos = 0;
        flatten(nestedList);
    }

    private void flatten(List<NestedInteger> list) {
        for (NestedInteger element : list) {
            if (element.isInteger()) {
                // add to flatList
                flatList.add(element.getInteger());
            } else {
                // recursive call
                flatten(element.getList());
            }
        }
    }

    @Override
    public Integer next() {
        // according to Java specs, interator should throw a NoSuchElementException
        // if there is no next element
        if (!hasNext()) throw new NoSuchElementException();
        return flatList.get(pos++);
    }

    @Override
    public boolean hasNext() {
        if (pos == flatList.size())
            return false;
        return true;
    }
}