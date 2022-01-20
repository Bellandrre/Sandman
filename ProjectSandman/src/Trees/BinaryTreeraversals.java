package Trees;
import java.util.*;

public class BinaryTreeraversals {

    static TreeNode root;

    public static void inOrderiterative(){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();

        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.isEmpty()) break;

                TreeNode currNode = stack.pop();

                System.out.println(currNode.value);
                root = currNode.right;
            }
        }
    }

    
}
