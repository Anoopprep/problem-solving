/**
 * 404. Sum of Left Leaves
 * Time Complexity: O(n)
 */

package Trees;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
     
    public int helper(TreeNode root, boolean isLeft) {
        if(root == null) return 0;
        if(root.left == null && root.right == null && isLeft) return root.val;

        int leftSum = helper(root.left, true);
        int rightSum = helper(root.right, false);

        return leftSum + rightSum;
    }
}
