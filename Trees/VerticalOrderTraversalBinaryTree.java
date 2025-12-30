package Trees;

import java.util.*;

class NodePosition {
    TreeNode node;
    int x;
    int y;

    NodePosition(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

public class VerticalOrderTraversalBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<NodePosition> q = new LinkedList<NodePosition>();
        q.add(new NodePosition(root, 0, 0));
        Map<Integer, ArrayList<NodePosition>> resMap = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        while(!q.isEmpty()){
            NodePosition np = q.poll();
            resMap.putIfAbsent(np.y, new ArrayList<>());
            resMap.get(np.y).add(np);
            if(np.node.left != null) q.add(new NodePosition(np.node.left, np.x + 1, np.y - 1));
            if(np.node.right != null) q.add(new NodePosition(np.node.right, np.x + 1, np.y + 1));
        }

        int y = 0;
        while (resMap.containsKey(y)) {
            List<NodePosition> list = resMap.get(y++);
            list.sort(Comparator
                        .comparingInt((NodePosition obj) -> obj.x)
                        .thenComparingInt(obj -> obj.node.val));
            List<Integer> col = new ArrayList<>();
            for (NodePosition np : list) {
                col.add(np.node.val);
            }
            res.add(col);
        }

        y = -1;
        while (resMap.containsKey(y)) {
            List<NodePosition> list = resMap.get(y--);
            list.sort(Comparator
                        .comparingInt((NodePosition obj) -> obj.x)
                        .thenComparingInt(obj -> obj.node.val));
            List<Integer> col = new ArrayList<>();
            for (NodePosition np : list) {
                col.add(np.node.val);
            }
            res.add(0, col);
        }
        return res;
    }
}
