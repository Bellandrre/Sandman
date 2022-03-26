package Trees;

import java.util.List;
public class ReconstructBST {

    static class TreeInfo{
        int index = 0;
        public TreeInfo(int index){
            this.index = index;
        }
    }

    /**
     * O(n2) solution
     * The first element of the pre order traversal will always be the root node.
     * Find the first element greater than the root node (let say i) and recurse i -1 and i + 1;
     * @param array
     * @param index
     * @param low
     * @param high
     * @return
     */
    public static TreeNode constructBinarySearchTreeHelper(int array[], int index, int low, int high){
        if(index >= array.length || high > low) {
            return null;
        }
        // Take the first node of the given sub array
        TreeNode root = new TreeNode(array[index]);
        index += 1;

        if(low == high){
            return root;
        }

        int i;
        for(i = low; i <= high; i++){
            if(array[i] > root.value){
                break;
            }
        }

        root.left = constructBinarySearchTreeHelper(array, index, i - 1, high);
        root.right = constructBinarySearchTreeHelper(array,index, low, i + 1);

        return root;
    }

    /**
     * O(n2)
     * @param array
     * @return
     */
    public static TreeNode constructBinarySearchTreeHelper(List<Integer> array){
        if(array.size() == 0)
            return null;

        int currentValue = array.get(0);
        int limitOnRight = 0;

        for(int i = 1; i < array.size() ; i++){
            if(currentValue < array.get(i)){
                limitOnRight = i;
                break;
            }
        }

        TreeNode leftSubTree  = constructBinarySearchTreeHelper(array.subList(0, limitOnRight));
        TreeNode rightSubTree = constructBinarySearchTreeHelper(array.subList(limitOnRight, array.size()));

        TreeNode curr = new TreeNode(currentValue);
        curr.left = leftSubTree;
        curr.right = rightSubTree;

        return curr;
    }

    /**
     * Keep track of minimum and maximum bounds.
     *
     * @param array
     * @param minimumBound
     * @param maximumBound
     * @param nodeInfo
     * @return
     */
    public static TreeNode constructBinarySearchTreeHelper(List<Integer> array, int minimumBound, int maximumBound, TreeInfo nodeInfo){
        if(nodeInfo.index == array.size())
            return null;

        int currentValue = array.get(nodeInfo.index);
        if(currentValue < minimumBound || currentValue >= maximumBound)
            return null;
        nodeInfo.index++;
        TreeNode leftSubTree  = constructBinarySearchTreeHelper(array, minimumBound, currentValue, nodeInfo);
        TreeNode rightSubTree = constructBinarySearchTreeHelper(array, currentValue, maximumBound, nodeInfo);

        TreeNode root = new TreeNode(currentValue);
        root.left = leftSubTree;
        root.right = rightSubTree;

        return root;
    }

}
