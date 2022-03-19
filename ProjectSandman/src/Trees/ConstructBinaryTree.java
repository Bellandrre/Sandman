package Trees;

public class ConstructBinaryTree {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        /**
         * Insert a new BST node
         *
         * @param value
         * @return BST
         */
/*        public BST insert(int value) {
            if (value < this.value) {
                BST leftNode = this.left;
                while (leftNode.left != null) {
                    leftNode = leftNode.left;
                }
                leftNode.left = new BST(value);
            } else {
                BST rightNode = this.right;
                while (rightNode.right != null) {
                    rightNode = rightNode.right;
                }
                rightNode.right = new BST(value);
            }
            return this;
        }*/

        /**
         * Contains a BST node
         *
         * @param value
         * @return boolean
         */
        public boolean contains(int value) {
            BST currNode = this;
            if (currNode.value == value)
                return true;
            else {
                while (currNode != null) {

                    if (currNode.value == value)
                        return true;

                    if (value < currNode.value) {
                        currNode = currNode.left;
                    } else {
                        currNode = currNode.right;
                    }
                }
                return false;
            }
        }

        public BST findMin(BST root) {
            if (root != null) {
                while (root.left != null) {
                    root = root.left;
                }
                return root;
            }
            return null;
        }

        public BST findMax(BST root) {
            if (root != null) {
                while (root.right != null) {
                    root = root.right;
                }
                return root;
            }
            return null;
        }

        /**
         * 1) Remove the leaf
         * 2) A node with a left child only
         * 3) A node with right child only
         * 4) A node with both children
         *
         * @param value
         * @return BST
         */
        public BST remove(int value) {
            remove(this, value);
            return this;
        }

        public void remove(BST root, int value) {
            if (root == null) {
                return;
            }
            if (value < root.value) {
                remove(root.left, value);
            } else if (value > root.value) {
                remove(root.right, value);
            } else {
                // Leaf Node
                if (root.left == null && root.right == null) {
                    root = null;
                }
                //left child only
                else if (root.right == null) {
                    root = root.left;
                }
                // right child only
                else if (root.left == null) {
                    root = root.right;
                }
                // Node with both children
                // We can either findMin from right sub tree
                // or findMax from left sub tree
                else {
                    BST minFromRight = findMin(root.right);
                    root.value = minFromRight.value;
                    remove(root.right, value);
                }
            }
        }
    }
}
