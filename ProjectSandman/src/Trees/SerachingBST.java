package Trees;

public class SerachingBST {
    static TreeNode root;

    public static TreeNode search(TreeNode root, int val){
        TreeNode subTree = null;

        while(root != null){
            if(val > root.value){
                root = root.right;
            }else if(val < root.value){
                root = root.left;
            }else{
                // Construct Subtree
                subTree = constructSubTree(root);
                break;
            }
        }
        return subTree;
    }

    public static TreeNode constructSubTree(TreeNode root){
        if(root == null) return null;
        TreeNode subtree = new TreeNode(root.value);
        subtree.left = constructSubTree(root.left);
        subtree.right = constructSubTree(root.right);
        return subtree;
    }

    public static void printTree(TreeNode root){
        if(root != null){
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);

        TreeNode subtree = search(root, 2);

        printTree(subtree);


    }

}
