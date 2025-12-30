/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Algorithm:
 * Start from the root node of the BST.
 * If both p and q are smaller than root, then LCA lies in left subtree.
 * If both p and q are greater than root, then LCA lies in right subtree.
 * If one of p or q is on one side and the other is on the other side, then root is LCA.
 */

package Trees;

public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
    }
}
