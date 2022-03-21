package Trees;

import java.util.Stack;
public class ValidateBST {

    /**
     * This wont work if there are duplicates in the tree
     * @param root
     * @return
     */
    public static boolean isBST(TreeNode root){
        int min_value =  - Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(root.value <= min_value) return false;

            root = root.right;
        }
        return true;
    }

    public static boolean validateBst(TreeNode tree) {
        // Write your code here.
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        return validateBstHelper(tree, min, max);
    }

    public static boolean validateBstHelper(TreeNode tree,int min,int max){
        if(tree == null) return true;

        if(tree.value >= max || tree.value < min) return false;
        return validateBstHelper(tree.left, min, tree.value) && validateBstHelper(tree.right, tree.value, max);
    }
}
