package Trees;

/**
 *
 * One thing to watch out here is the left shift and ORing to get the decimal number
 */

public class SummOfRootToLeafBinaryNumbers {

    int rootToleaf =  0;
    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeafHelper(root, 0);
        return rootToleaf;
    }

    public void sumRootToLeafHelper(TreeNode root, int currentNumber){
        if(root != null){
            currentNumber = (currentNumber << 1) | root.value;
            if(root.left == null && root.right == null){
                rootToleaf += currentNumber;
            }
            sumRootToLeafHelper(root.left, currentNumber);
            sumRootToLeafHelper(root.right, currentNumber);
        }
    }

}
