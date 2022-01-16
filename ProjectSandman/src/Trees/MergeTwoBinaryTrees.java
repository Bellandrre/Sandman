package Trees;

public class MergeTwoBinaryTrees {

    static TreeNode root1;
    static TreeNode root2;

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null && root2 != null)
            return root2;
        if(root1 != null && root2 == null){
            return root1;
        }

        TreeNode sum = new TreeNode(root1.value + root2.value);
        sum.left = mergeTrees(root1.left, root2.left);
        sum.right = mergeTrees(root1.right, root2.right);
        return sum;
    }

    public static void printTree(TreeNode node){
        if(node != null){
            System.out.print(node.value +" ");
            printTree(node.left);
            printTree(node.right);
        }

    }

    public static void main(String[] args) {

        root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);

        root2 = new TreeNode(2);
        root2.left  = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        TreeNode mergedTree = mergeTrees(root1, root2);

        printTree(mergedTree);


    }
}
