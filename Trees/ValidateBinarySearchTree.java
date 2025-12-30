/**
 * 98. Validate Binary Search Tree
 */

package Trees;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode node) {
        return helper(node, null, null);
    }

    private boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;

        return helper(node.left, min, node.val) &&
               helper(node.right, node.val, max);
    }
}
