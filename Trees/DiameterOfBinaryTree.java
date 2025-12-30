/**
 * 543. Diameter of Binary Tree
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
