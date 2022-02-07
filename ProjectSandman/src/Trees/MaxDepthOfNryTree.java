package Trees;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

public class MaxDepthOfNryTree {

    static NaryTreeNode root;


    public static int maxDepth(NaryTreeNode root){
        if(root == null) return 0;

        Stack<Pair<NaryTreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair(root, 1));
        int maxDepth = 0;

        while(!stack.isEmpty()){
            Pair currentNode = stack.pop();
            NaryTreeNode node = (NaryTreeNode) currentNode.getKey();
            int currentDepth = (int) currentNode.getValue();

            maxDepth = Math.max(maxDepth, currentDepth);

            for(NaryTreeNode n : node.children){
                if(n != null)
                    stack.push(new Pair(n, currentDepth+1));
            }

        }
        return maxDepth;
    }

    public static void main(String[] args) {
        NaryTreeNode newNode_1 = new NaryTreeNode();
        newNode_1.val = 1;

        NaryTreeNode newNode_2 = new NaryTreeNode();
        newNode_2.val = 2;

        NaryTreeNode newNode_3 = new NaryTreeNode();
        newNode_3.val = 3;

        NaryTreeNode newNode_4 = new NaryTreeNode();
        newNode_4.val = 4;

        NaryTreeNode newNode_5 = new NaryTreeNode();
        newNode_5.val = 5;

        NaryTreeNode newNode_6 = new NaryTreeNode();
        newNode_6.val = 6;

        newNode_1.children = Arrays.asList(newNode_3, newNode_2, newNode_4);
        newNode_3.children = Arrays.asList(newNode_5, newNode_6);

        root = newNode_1;

        System.out.println(maxDepth(root));

    }

}
