package Trees;

public class SearchInTrees {

    static TreeNode root;


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

    }
}
