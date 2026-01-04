/**
 * 572. Subtree of Another Tree
 * For each node in the main tree, check if the subtree rooted at that node is identical to the subRoot.
 * Time Complexity: O(m * n) in worst case, where m and n are the number of nodes in the main tree and subRoot respectively.
 */
package Trees;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q== null) return true;
        if(p == null) return false;
        if(q == null) return false;
        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
