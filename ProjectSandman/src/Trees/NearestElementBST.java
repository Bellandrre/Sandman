package Trees;

public class NearestElementBST {


    static TreeNode root;

    public static int nearestElementBST(TreeNode root, int target){
        int minDifference = nearestElementBSTHelper(root, target, Integer.MAX_VALUE, -1);
        return minDifference;
    }

    public static int nearestElementBSTHelper(TreeNode root, int target, int minDifference, int minDiffValue){
        if(root == null){
            return minDiffValue;
        }

        if(root.value == target){
            minDifference = 0;
            minDiffValue = root.value;
            return minDiffValue;
        }

        if(target < root.value){
            int currDiff = root.value - target;
            if(currDiff < minDifference){
                minDifference = currDiff;
                minDiffValue = root.value;
            }
            return nearestElementBSTHelper(root.left, target, minDifference, minDiffValue);
        }else{
            int currDiff = target - root.value;
            if(currDiff < minDifference){
                minDifference = currDiff;
                minDiffValue = root.value;
            }
           return nearestElementBSTHelper(root.right, target, minDifference, minDiffValue);
        }
    }

    public static void main(String[] args) {
        root = new TreeNode();
        root.value = 1;
        root.left = null;
        root.right = new TreeNode(2);

        int answer = nearestElementBST(root, 3);

        System.out.println(answer);

    }


}
