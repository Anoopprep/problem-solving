/**
 * 543. Diameter of Binary Tree
 * Variant of Depth of Binary Tree
 * Same as depth, just add one more variable to keep track of maximum diameter.
 * Diameter counts the edges, not the nodes. So, we return left + right instead of left + right + 1.
 */

package Trees;

public class DiameterOfBinaryTree {
    int global = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return global;
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;

        int left = depth(root.left);
        int right = depth(root.right);
        global = Math.max(global, left + right);
        return Math.max(left, right) + 1;
    }
}
