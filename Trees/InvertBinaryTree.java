/**
 * 226. Invert Binary Tree
 */

package Trees;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left; 
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    // public TreeNode invertTree(TreeNode root) {
    //     if(root == null) return null;

    //     TreeNode temp = root.left; 
    //     root.left = root.right; 
    //     root.right = temp;

    //     invertTree(root.left);
    //     invertTree(root.right);

    //     return root;
    // }
}
