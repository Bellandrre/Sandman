package Trees;

public class ConvertSortedArrayBinarySearchTree {

    static int nums[];

    public static TreeNode sorteArrayBST(int arr[]){
        nums = arr;
        return sortedArrayToBSTHelper(0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBSTHelper(int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end)/2;

        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = sortedArrayToBSTHelper(start, mid - 1);
        newNode.right = sortedArrayToBSTHelper(mid + 1, end);
        return newNode;
    }

    public static void printTree(TreeNode root){
        if(root != null){
            printTree(root.left);
            System.out.println(root.value);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        int arr[] = {-10,-3,0,5,9};
        TreeNode root = sorteArrayBST(arr);
        printTree(root);
    }
}
