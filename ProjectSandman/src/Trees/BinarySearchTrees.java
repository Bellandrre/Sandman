package Trees;

public class BinarySearchTrees {

    public static TreeNode root;


    public static void insertNode(int value){

        if(root == null){
            root = new TreeNode(value);
            return;
        }
       TreeNode currNode = root;
       TreeNode prev = currNode;

       while(currNode != null){
           if(value < currNode.value){
               prev = currNode;
               currNode = currNode.left;
           }else{
               prev = currNode;
               currNode = currNode.right;
           }
       }

       if(value < prev.value){
           prev.left = new TreeNode(value);
       }else{
           prev.right = new TreeNode(value);
       }
    }

    public static TreeNode deleteNode(int value){
        deleteNodeHelper(root,value);
        return root;
    }

    public static void deleteNodeHelper(TreeNode root, int value){

        if(root == null){
            return;
        }

        while(root != null || root.value != value){

        }


        if (root.left == null && root.right == null) {
            root = null;
        }// node has left child only
        else if (root.right == null) {
            root = root.left;
        }// node has right child only
        else if (root.left == null) {
            root = root.right;
        } else {
            TreeNode node = findMinimum(root);
            deleteNode(node.value);
        }
    }

    public static TreeNode findMinimum(TreeNode root){
        TreeNode currNode = root;
        if(currNode == null){
            return null;
        }else{
            while(currNode.left != null){
                currNode = currNode.left;
            }
            return currNode;
        }
    }

    public static void printTree(TreeNode root){
        if(root != null){
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTrees.insertNode(20);
        BinarySearchTrees.insertNode(25);
        BinarySearchTrees.insertNode(9);
        BinarySearchTrees.insertNode(12);
        BinarySearchTrees.insertNode(14);
        BinarySearchTrees.insertNode(11);
        BinarySearchTrees.insertNode(5);

        BinarySearchTrees.deleteNode(14);


        BinarySearchTrees.printTree(root);
    }
}
