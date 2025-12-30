/**
 * 100. Same Tree
 * For true condition, you'll have to go till null and only null is true, else if you return true on null nodes,
 * you are returning the result early without checking the rest of the tree.
 */

package Trees;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q== null) return true;
        if(p == null) return false;
        if(q == null) return false;
        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
