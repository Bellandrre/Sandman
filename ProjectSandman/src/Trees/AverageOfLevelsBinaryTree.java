package Trees;
import java.util.*;

/**
 * This is a level order traversal where we are using Two Queues and the thing to notice here is that
 * we have two while loopps with isEmpty on the same que.
 */
public class AverageOfLevelsBinaryTree {
    static TreeNode root;

    public static List<Double> averageOfLevels(TreeNode root){
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        que.addLast(root);

        while(!que.isEmpty()){
            long sum = 0, count = 0;
            Deque<TreeNode> temp = new LinkedList<>();
            while(!que.isEmpty()){
                TreeNode n = que.remove();
                sum += n.value;
                count++;

                if(n.left != null) temp.addLast(n.left);
                if(n.right != null) temp.addLast(n.right);
            }

            que = temp;
            result.add(sum*1.0/count);
        }
        return result;
    }
}
