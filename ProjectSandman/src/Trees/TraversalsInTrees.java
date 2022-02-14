package Trees;
import java.util.*;

/**
 * Search in normal trees
 *
 */
public class TraversalsInTrees {

    static TreeNode root;
    static NaryTreeNode naryRoot;


    public static void preOrderTraversal(TreeNode root){
        if(root!= null){
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void inOrderTraversal(TreeNode root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.println(root.value);
            inOrderTraversal(root.right);
        }
    }

    public static void inOrderIterativeTraversal(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){

            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.value+ " ");
            curr = curr.right;
        }
    }


    public static void postOrderTraversal(TreeNode root){
        if(root != null){
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         System.out.println(root.value);
        }
    }


    public static void postOrderIterativeTraversal(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode currentNode = stack1.pop();

            if(currentNode.left != null){
                stack1.push(currentNode.left);
            }
            if(currentNode.right != null){
                stack1.push(currentNode.right);
            }
            stack2.push(currentNode);
        }

        for(TreeNode curr : stack2){
            System.out.print(curr.value + " ");
        }
    }

    public static void preOrderTraversalIterative(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            TreeNode currNode = stack.pop();
            result.add(currNode.value);
            if(currNode.right != null)
                stack.push(currNode.right);

            if(currNode.left != null)
                stack.push(currNode.left);

        }

    }

    public static void naryPreOrderTraversalItervative(NaryTreeNode root){
        if(root == null) return;

        Stack<NaryTreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            NaryTreeNode currNode = stack.pop();
            System.out.println(currNode.val);

            Collections.reverse(currNode.children);

            for(NaryTreeNode n : currNode.children){
                stack.push(n);
            }
        }
    }

    


    public static void levelOrderTraversalsWithBreaks(TreeNode root){
        Deque<TreeNode> que = new LinkedList<>();

        que.addLast(root);
        que.addLast(null);


        while(!que.isEmpty()){
            TreeNode currentNode = que.pollFirst();
            if(currentNode == null && que.peek() == null) break;
            if(currentNode == null){
                System.out.println();
                que.addLast(null);

            }else{
                System.out.print(currentNode.value + " ");
                que.addLast(currentNode.left);
                que.addLast(currentNode.right);
            }
        }
    }


    public static boolean contains(TreeNode root, int value){
        if(root == null) return false;
        if(root.value == value) return true;
        return contains(root.left, value) || contains(root.right, value);
    }


    public static void main(String[] args) {
        root = new TreeNode(55);

        root.left = new TreeNode(87);
        root.left.right = new TreeNode(42);
        root.left.left = new TreeNode(-3);

        root.right = new TreeNode(29);
        root.right.right = new TreeNode(60);
        root.right.left = new TreeNode(60);


        System.out.println(contains(root,-10));
        System.out.println(contains(root,-1));
        System.out.println(contains(root,60));

        preOrderTraversal(root);

        //levelOrderTraversal(root);

        inOrderIterativeTraversal(root);


    }
}
