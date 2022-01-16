package Trees;

public class IncreasingBST {

    static TreeNode root;
    static TreeNode newTree;

    public static TreeNode increasingBST(TreeNode root){
        TreeNode ans = new TreeNode(0);
        newTree = ans;
        increasingBSTHelper(root);
        return ans.right;
    }

    public static void increasingBSTHelper(TreeNode root){
        if(root != null){
            increasingBSTHelper(root.left);
            newTree.right = new TreeNode(root.value);
            newTree = newTree.right;
            increasingBSTHelper(root.right);
        }
    }


    public static void main(String[] args) {
        root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(7);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        TreeNode result = increasingBST(root);

        while(result != null){
            System.out.print(result.value + " ");
            result = result.right;
        }
    }
}
