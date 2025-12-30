/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Algorithm: 
 * For every node, check if it is equal to p or q.
 * If yes, return that node.
 * Else, recursively call for left and right subtrees.
 * If both left and right calls return non-null values, then that node is the LCA.
 * If one of them is null, return the non-null value.
 */

package Trees;

public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p) return p;
        if(root == q) return q;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}
