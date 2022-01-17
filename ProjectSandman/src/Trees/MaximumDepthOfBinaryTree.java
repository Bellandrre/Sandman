package Trees;

public class MaximumDepthOfBinaryTree {


    static TreeNode root;
    static int maxDepth = Integer.MIN_VALUE;


    public static int maxDepth(TreeNode root){
        if(root == null) {
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

}
