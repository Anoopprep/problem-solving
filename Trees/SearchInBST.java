/**
 * 700. Search in a Binary Search Tree
 */

package Trees;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        if(root.val == val) return root;

        if(val < root.val) return searchBST(root.left, val);

        else return searchBST(root.right, val);
    }
}
