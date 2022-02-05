package Trees;
import java.util.*;

public class NaryTreePostOrderTraversal {


    public List<Integer> postOrdewrTraversal(NaryTreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<NaryTreeNode> stack1 = new Stack<>();
        Stack<NaryTreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            NaryTreeNode currentNode = stack1.pop();

            List<NaryTreeNode> children = currentNode.children;

            for(NaryTreeNode node : children){
                if(node != null) stack1.push(node);
            }

            stack2.push(currentNode);
        }

        while(!stack2.isEmpty()){
            result.add(stack2.pop().val);
        }

        return result;
    }
}
