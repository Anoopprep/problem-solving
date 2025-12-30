/**
 * 104. Maximum Depth of Binary Tree
 */

package Trees;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);
        return Math.max(leftCount, rightCount) + 1;
    }
}
