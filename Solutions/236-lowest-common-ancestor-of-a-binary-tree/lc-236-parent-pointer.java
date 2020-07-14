import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        parent.put(root, null);

        // keep adding parent pointers until both find p and q 
        while(!parent.containsKey(p) || !parent.containsKey(q)) {
            // bfs
            TreeNode cur = queue.poll();
            if (cur != null) {
                // null could be the key but this doesn't matter in this question
                parent.put(cur.left, cur);
                parent.put(cur.right, cur);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }

        // put all the ancestors of p into our set
        Set<TreeNode> set = new HashSet<>();
        TreeNode ancestorOfP = p;
        while(ancestorOfP != null) {
            set.add(ancestorOfP);
            ancestorOfP = parent.get(ancestorOfP);
        }

        // check the first ancestor of q which is also in the set
        TreeNode ancestorOfQ = q;
        while(!set.contains(ancestorOfQ)) {
            ancestorOfQ = parent.get(ancestorOfQ);
        }

        return ancestorOfQ;
    }
}

/*
Time: O(n)

Space: O(n)
*/