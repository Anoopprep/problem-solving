package Trees;
import java.util.*;

class Pair {
    TreeNode node;
    int pos;

    Pair(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}

public class TopViewOfBinaryTree {
    public ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        if(root == null) return res;
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            if(!set.contains(p.pos)) {
                set.add(p.pos);
                if(p.pos < 0) {
                    res.add(0, p.node.val);
                } else {
                    res.add(p.node.val);
                }
            }
            
            if(p.node.left != null) {
                q.add(new Pair(p.node.left, p.pos - 1));
            }
            
            if(p.node.right != null) {
                q.add(new Pair(p.node.right, p.pos + 1));
            }
        }
        
        return res;
    }
}
