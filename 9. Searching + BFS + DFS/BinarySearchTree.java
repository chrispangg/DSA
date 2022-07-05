import java.util.ArrayList;

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

    public void breadthFirstSearch() {
        BinaryTreeNode currentNode = this.root;
        ArrayList<BinaryTreeNode> queue = new ArrayList<BinaryTreeNode>();

        // BFS works by adding the child nodes into a list while reading the nodes as we
        // traverse.
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove(0);
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        // prints 9 4 20 6 15 170, which is in the order of BFS
    }

    public ArrayList<BinaryTreeNode> breadthFirstSearchRecursive(ArrayList<BinaryTreeNode> queue) {
        if (queue.isEmpty())
            return queue;

        BinaryTreeNode currentNode = queue.remove(0);
        System.out.print(currentNode.data + " ");
        if (currentNode.left != null) {
            queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right);
        }
        breadthFirstSearchRecursive(queue);

        // prints 9 4 20 1 6 15 170, which is in the order of BFS
        return queue;
    }

    // DFS is usually implemented with Recursion
    public ArrayList<BinaryTreeNode> depthFirstSearchPreorder(BinaryTreeNode node, ArrayList<BinaryTreeNode> list) {
        list.add(node);
        System.out.print(node.data + ", ");
        
        if (node.left != null) {
            depthFirstSearchPreorder(node.left, list);
        }
        if (node.right != null) {
            depthFirstSearchPreorder(node.right, list);
        }

        return list;
    }

    public ArrayList<BinaryTreeNode> depthFirstSearchInorder(BinaryTreeNode node, ArrayList<BinaryTreeNode> list) {
        if (node.left != null) {
            depthFirstSearchInorder(node.left, list);
        }
        // with Inorder we add node
        list.add(node);
        System.out.print(node.data + ", ");


        if (node.right != null) {
            depthFirstSearchInorder(node.right, list);
        }
        return list;
    }

    public ArrayList<BinaryTreeNode> depthFirstSearchPostorder(BinaryTreeNode node, ArrayList<BinaryTreeNode> list) {
        if (node.left != null) {
            depthFirstSearchPostorder(node.left, list);
        }
        if (node.right != null) {
            depthFirstSearchPostorder(node.right, list);
        }

        list.add(node);
        System.out.print(node.data + ", ");

        return list;
    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();

        t.insert(9);
        t.insert(4);
        t.insert(6);
        t.insert(20);
        t.insert(170);
        t.insert(15);
        t.insert(1);
        
        // t.breadthFirstSearch();

        ArrayList<BinaryTreeNode> queue = new ArrayList<BinaryTreeNode>();
        BinaryTreeNode rootNode = t.root;
        // queue.add(rootNode);
        // t.breadthFirstSearchRecursive(queue);

        // StringBuilder sb = new StringBuilder();
        // System.out.println(printTree(t.root, sb));


        t.depthFirstSearchPreorder(rootNode, queue);
        System.out.println(" ");
        t.depthFirstSearchInorder(rootNode, queue);
        System.out.println(" ");
        t.depthFirstSearchPostorder(rootNode, queue);

        // 9
        // 4 20
        // 1 6 15 170
    }

}
