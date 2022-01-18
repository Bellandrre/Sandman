package Trees;

public class UnivaluedBinaryTree {
    boolean isUnival = true;

    public boolean isUnivalTree(TreeNode root) {
        int value = root.value;
        isUnivalTreeHelper(root, value);
        return isUnival;
    }

    public void isUnivalTreeHelper(TreeNode root, int value){
        if(root != null){
            if(root.value != value){
                isUnival = false;
            }
            isUnivalTreeHelper(root.left, value);
            isUnivalTreeHelper(root.right, value);
        }
    }
}
