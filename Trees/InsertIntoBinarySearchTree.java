package Trees;

public class InsertIntoBinarySearchTree {
    // My approach
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     TreeNode newnode = new TreeNode(val, null, null);
    //     if(root == null) {
    //         root = newnode;
    //         return root;
    //     }
    //     if(root.val > val) {
    //         if(root.left == null) {
    //             root.left = newnode;
    //             return root;
    //         }
    //         else insertIntoBST(root.left, val);
    //     }
    //     else {
    //         if(root.right == null) {
    //             root.right = newnode;
    //             return root;
    //         }
    //         else insertIntoBST(root.right, val);
    //     }
    //     return root;
    // }

    // Cleaner appraoch
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if(root == null) return new TreeNode(val);

    //     if(root.val > val) 
    //         root.left = insertIntoBST(root.left, val);
        
    //     else
    //         root.right = insertIntoBST(root.right, val);
        
    //     return root;
    // }

    // Iterative approach
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);

        if(root == null) return newNode;

        TreeNode temp = root;
        while(true) {
            if(temp.val > val) {
                if(temp.left == null) {
                    temp.left = newNode;
                    return root;
                }   
                else temp = temp.left;
            } else {
                if(temp.right == null) {
                    temp.right = newNode;
                    return root;
                }   
                else temp = temp.right;
            }
        }
    }
}
