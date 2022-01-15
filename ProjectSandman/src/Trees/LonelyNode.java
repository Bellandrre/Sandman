package Trees;
import java.util.List;
import java.util.ArrayList;

public class LonelyNode {

    static TreeNode root;


    public static List<Integer> getLonelyNodes(TreeNode root){
        List<Integer> result = new ArrayList<>();
        getLonelyHelper(root, false, result);
        return result;

    }

    public static void getLonelyHelper(TreeNode root, boolean isLonely, List<Integer> nodes){
        if(root == null) return;

        if(isLonely){
            nodes.add(root.value);
        }

        getLonelyHelper(root.left, root.right == null , nodes);
        getLonelyHelper(root.right, root.left == null , nodes);
    }

    public static void main(String[] args) {
        root = new TreeNode(7);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(6);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(2);

        List<Integer> result = getLonelyNodes(root);

        for(Integer i : result){
            System.out.print(i + " ");
        }

    }

}
