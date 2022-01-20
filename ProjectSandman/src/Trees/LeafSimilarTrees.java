package Trees;
import java.util.LinkedList;
import java.util.List;

import java.util.LinkedList;

public class LeafSimilarTrees {
    static  TreeNode root1;
    static TreeNode root2;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> resultNode1 = new LinkedList<>();
        List<Integer> resultNode2 = new LinkedList<>();
        leafSimilarHelper(root1, resultNode1);
        leafSimilarHelper(root2, resultNode2);

        if(resultNode1.size() != resultNode2.size()){
            return false;
        }else{
            for(int i = 0; i < resultNode1.size(); i++){
                if(resultNode1.get(i) != resultNode2.get(i)){
                    return false;
                }
            }
            return true;
        }
    }



    public static void leafSimilarHelper(TreeNode root, List<Integer> leafNodes){
        if(root == null) return;
        if(root.left == null && root.right == null){
            leafNodes.add(root.value);
            return;
        }
        leafSimilarHelper(root.left, leafNodes);
        leafSimilarHelper(root.right, leafNodes);
    }

}
