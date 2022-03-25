package Trees;

public class ConstructBST {

    public static TreeNode constructTree(int array[]){
        return constructTreeHelper(array, 0, array.length - 1);
    }

    public static TreeNode constructTreeHelper(int arr[], int low, int high){
        if(high < low) return null;
        int mid = (low + high)/2;
        TreeNode newNode = new TreeNode(arr[mid]);
        newNode.left  = constructTreeHelper(arr, low, mid - 1);
        newNode.right = constructTreeHelper(arr, mid + 1, high);
        return newNode;
    }
}
