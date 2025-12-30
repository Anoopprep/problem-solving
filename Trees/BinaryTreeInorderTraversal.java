/**
 * 94. Binary Tree Inorder Traversal
 * Inorder, preorder and postorder are DFS
 */

package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode node, List<Integer> res) {
        if(node == null) return;

        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }
}
