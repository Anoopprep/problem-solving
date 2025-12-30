/**
 * 102. Binary Tree Level Order Traversal
 * 1. Use one queue.
 * 2. The queue always contains nodes in BFS order.
 * At the start of each level: 
 *  a. take the current queue size → that number = nodes in this level.
 * 4. Process exactly that many nodes:
 *  a. pop node
 *  b. add its value to a temporary list (this level)
 *  c. push its children into the queue
 * 5. After processing those nodes: add the temporary list to the final result.
 * 6. Repeat until queue is empty.
 */

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(); // number of nodes in this level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            res.add(level);
        }
        return res;
    }
}
