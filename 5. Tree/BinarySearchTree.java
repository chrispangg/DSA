public class BinarySearchTree {
    class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    BinaryTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // All the right child nodes of the parent node must be greater than the current
    // node.
    public void insert(int data) {
        BinaryTreeNode newNode = new BinaryTreeNode(data);
        BinaryTreeNode currentNode = root;
        BinaryTreeNode parentNode = null;
        if (root == null) {
            root = newNode;
        } else {
            while (currentNode != null) {
                parentNode = currentNode;
                if (data < currentNode.data) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }
            if (data < parentNode.data) {
                parentNode.left = newNode;
            } else {
                parentNode.right = newNode;
            }
        }
    }

    public boolean lookup(int data) {
        boolean found = false;
        BinaryTreeNode currentNode = root;
        while (currentNode != null && !found) {
            if (currentNode.data == data) {
                found = true;
            } else if (currentNode.data > data) {
                currentNode = currentNode.left;
            } else if (currentNode.data < data) {
                currentNode = currentNode.right;
            }
        }

        return found;
    }

    public void remove(int data) {
        // look for the parent node that points to the delete node
        // store the parent node -
        // store the child node, aka delete node -
        // find the smallest value's parent's pointer -
        // find the smallest value in the right subtree of the delete node -
        // smallest value's parent's pointer points to null -
        // delete parent node left or right pointer points to smallest node -
        // smallest node right pointer points to the delete node's right child
        // smallest node left pointer points to the delete node's left child

        BinaryTreeNode currentNode = root;
        BinaryTreeNode parentNode = null;
        BinaryTreeNode deleteParentNode = null;
        BinaryTreeNode deleteNode = null;
        String parentPointer = "";

        // find delete node and it's parent
        while (currentNode != null) {
            if (currentNode.data == data) {
                deleteNode = currentNode;
                deleteParentNode = parentNode;
                break;
            } else if (currentNode.data > data) {
                parentNode = currentNode;
                parentPointer = "left";
                currentNode = currentNode.left;
            } else if (currentNode.data < data) {
                parentNode = currentNode;
                parentPointer = "right";
                currentNode = currentNode.right;
            }
        }

        // Case 1: remove from tree if it's the leaf of the tree
        if (currentNode.left == null && currentNode.right == null) {
            if (parentPointer == "left") {
                parentNode.left = null;
            } else if (parentPointer == "right") {
                parentNode.right = null;
            }
            // Case 2: promote child if only single
        } else if (currentNode.left == null && currentNode.right != null) {
            parentNode.right = currentNode.right;
        } else if (currentNode.left != null && currentNode.right == null) {
            parentNode.left = currentNode.left;
            // Case 3: find and promote inorder successor
        } else {
            parentNode = currentNode;
            currentNode = currentNode.right;
            // find the smallest value
            while (currentNode.left != null) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            }

            // smallest value's parent points to null;
            parentNode.left = null;

            // delete parent node left or right pointer points to smallest node
            if (deleteParentNode != null) {
                if (deleteParentNode.left == deleteNode) {
                    deleteParentNode.left = currentNode;
                } else {
                    deleteParentNode.right = currentNode;
                }
            } else {
                root = currentNode;
            }

            // smallest node right pointer points to the delete node's right child
            currentNode.right = deleteNode.right;
            currentNode.left = deleteNode.left;
            
        }

    }

    // print it in jSON format
    public static String printTree(BinaryTreeNode root, StringBuilder sb) {
        if (root == null) {
            return "null";
        }
        sb.append("{");
        sb.append("\"data\": " + root.data);
        sb.append(", \"left\": ");
        if (root.left == null) {
            sb.append("null");
        } else {
            printTree(root.left, sb);
        }
        sb.append(", \"right\": ");
        if (root.right == null) {
            sb.append("null");
        } else {
            printTree(root.right, sb);
        }

        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        t.insert(6);
        t.insert(2);
        t.insert(1);
        t.insert(9);
        t.insert(8);
        t.insert(15);
        t.insert(13);
        t.insert(18);
        t.insert(11);
        StringBuilder sb = new StringBuilder();

        t.remove(9);
        System.out.println(printTree(t.root, sb));
    }

}

// 9
// 4 20
// 1 6 15 50
