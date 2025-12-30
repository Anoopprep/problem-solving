/**
 * 230. Kth Smallest Element in a BST
 * Inorder traversal of BST gives elements in sorted order ascending
 * 
 * First solution: time and space: o(n)
 * Second: 
 * space: o(1)
 * time, best: o(height), worst: o(n), average: O(k + h), for balanced tree, h = o(logn), for skewed, h = o(n)
 */

package Trees;

// import java.util.ArrayList;
// import java.util.List;

public class KthSmallestElementBST {
    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     inOrderTraversal(root, res);
    //     return res.get(k-1);
    // }

    // private void inOrderTraversal(TreeNode node, List<Integer> res) {
    //     if(node == null) return;

    //     inOrderTraversal(node.left, res);
    //     res.add(node.val);
    //     inOrderTraversal(node.right, res);
    // }

    int count = 0, value;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return value;
        if(count == k) return value;

        kthSmallest(root.left, k);
        if(count < k) {
            value = root.val;
            count++;
        }
        if(count == k) return value;
        kthSmallest(root.right, k);

        return value;
    }
}
