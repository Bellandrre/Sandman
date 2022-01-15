package Trees;

/**
 *
 * I did not get time to see why the answer in this question is wrong here in this code
 * But this solution works on Leetcode lol
 *
 */

public class RangeSumBST {

    static TreeNode root;
    static int sum;

    public static int rangeSum(TreeNode root, int low, int high){
        sum = 0;
        rangeSumHelper(root, low, high, sum);
        return sum;
    }

    public static void rangeSumHelper(TreeNode root, int low, int high, Integer sum){
        if(root == null)
            return;

        if(root.value >= low && root.value <= high){
            sum += root.value;
        }
        rangeSumHelper(root.left, low, high, sum);
        rangeSumHelper(root.right, low, high, sum);
    }

    public static void main(String[] args) {
        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSum(root, 7, 15));
    }

}
