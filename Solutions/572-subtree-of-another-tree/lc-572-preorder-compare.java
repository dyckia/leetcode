// get the preorder traversal string of the two trees
// check whether string t is a sub string of s

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String preS = getPreString(s);
        String preT = getPreString(t);
        // Java's in-built indexOf method costs m*n time
        return (preS.indexOf(preT) == -1) ? false : true;
    }
    
    // return the preorder traversal string of a given tree
    // mark left null child as l and right null child as r
    // prepend the value with a # sign so we won't treat 23rl and 3rl the same
    private String getPreString(TreeNode x) {
        StringBuilder str = new StringBuilder();
        if (x == null) return str.toString();

        str.append('#');
        str.append(x.val);

        if (x.left == null) str.append('l');
        else str.append(getPreString(x.left));

        if (x.right == null) str.append('r');
        else str.append(getPreString(x.right));

        return str.toString();
    }
}

/*
Time: O(m + n + m * n)
m + n for building the two preorder strings
m * n for java's in-built indexOf method 
(if we use KMP substring search algorithm 
we can futher improve the time to m + n)

Space: O(max(m, n))
call stack for building the string
*/