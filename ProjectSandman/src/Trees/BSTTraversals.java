package Trees;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class BSTTraversals {

    public BSTTraversals(){

    }

    public static List<Integer> inOrderTraversal(TreeNode tree, List<Integer> array){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = tree;
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty() || curr != null){

            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.value);
            curr = curr.right;
        }
        return result;
    }

    public static List<Integer> postOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();

        while(!stack.isEmpty() || curr != null){

            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode topNode = stack.peek();
                if(topNode.right == null){
                    result.add(topNode.value);
                    topNode = stack.pop();
                    while(!stack.isEmpty() && topNode == stack.peek().right){
                        topNode = stack.pop();
                        result.add(topNode.value);
                    }
                }else{
                    curr = topNode.right;
                }
            }
        }
        return result;
    }

    public static List<Integer> preOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();

        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                result.add(curr.value);
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode popNode = stack.pop();
                curr = popNode.right;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = preOrderTraversal(root);

        for(Integer i : result){
            System.out.print(i + " ");
        }
    }
}
