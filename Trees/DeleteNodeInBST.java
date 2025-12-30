/**
 * 450. Delete Node in a BST
 * For Tree questions, Each node returns the root of its updated subtree.
 */

package Trees;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.right == null) return root.left;

            TreeNode smallest = root.right;
            while(smallest.left != null) smallest = smallest.left;
            root.val = smallest.val;
            root.right = deleteNode(root.right, smallest.val);
        }

        else if(key < root.val) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        return root;
    }
}
