import java.util.Stack;
import java.util.ArrayDeque;

class Node {
    private int value;
    private Node left;
    private Node right;
    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Node getLeft() {
        return this.left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return this.right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
class Tree {
    private Node root;
    public Tree() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value, null, null);
        } else {
            if (node.getValue() > value) {
                node.setLeft(insert(node.getLeft(), value));
            } else {
                node.setRight(insert(node.getRight(), value));
            }
        }
        return node;
    }

    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.print(node.getValue() + ", ");
        }
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getValue() + ", ");
            printInOrder(node.getRight());
        }
    }

    public void printBreadthFirst() {
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        Node temp;
        if (root != null) {
            queue.add(root);
        }
        while (queue.isEmpty() == false){
            temp = queue.remove();
            System.out.print(temp.getValue() + ", ");
            if (temp.getLeft() != null)
                queue.add(temp.getLeft());
            if (temp.getRight() != null)
                queue.add(temp.getRight());
        }
        System.out.println();
    }

    public void printDepthFirst() {
        Stack<Node> stack = new Stack<Node>();
        Node temp;
        if (root != null) {
            stack.push(root);
        }
        while (stack.isEmpty() == false) {
            temp = stack.pop();
            System.out.print(temp.getValue() + ", ");
            if (temp.getLeft() != null)
                stack.push(temp.getLeft());
            if (temp.getRight() != null)
                stack.push(temp.getRight());
        }
        System.out.println();
    }

    public boolean find(int value) {
        Node currNode = root;
        while (currNode != null) {
            if (currNode.getValue() == value) {
                return true;
            } else if (currNode.getValue() > value) {
                currNode = currNode.getLeft();
            } else {
                currNode = currNode.getRight();
            }
        }
        return false;
    }

    public int findMin() {
        Node node = root;
        if (node == null) {
            return 0;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getValue();
    }

    public int findMax() {
        Node node = root;
        if (node == null) {
            return 0;
        }
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getValue();
    }

    public int treeDepth() {
        return treeDepth(root);
    }

    private int treeDepth(Node currNode) {
        if (currNode == null)
            return 0;
        else {
            int leftDepth = treeDepth(currNode.getLeft());
            int rightDepth = treeDepth(currNode.getRight());
            if (leftDepth > rightDepth)
                return leftDepth + 1;
            else
                return rightDepth + 1;
        }
    }

    public Node findMaxNode(Node currNode) {
        Node node = currNode;
        if (currNode == null) {
            return null;
        }
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }
    public Node findMinNode(Node currNode) {
        Node node = currNode;
        if (currNode == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node node, int value) {
        if (node != null) {
            if (node.getValue() == value) {
                if (node.getLeft() == null && node.getRight() == null) {
                    return null;
                } else {
                    if (node.getLeft() == null) {
                        return node.getRight();
                    }
                    if (node.getRight() == null) {
                        return node.getLeft();
                    }
                    Node minNode = findMinNode(node.getRight());
                    int minValue = minNode.getValue();
                    node.setValue(minValue);
                    node.setRight(deleteNode(node.getRight(), minValue));
                }
            } else {
                if (node.getValue() > value) {
                    node.setLeft(deleteNode(node.getLeft(), value));
                } else {
                    node.setRight(deleteNode(node.getRight(), value));
                }
            }
        }
        return node;
    }

    public boolean isEqual(Tree anotherTree) {
        return checkEquality(root, anotherTree.root);
    }

    private boolean checkEquality(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null || node2 == null)
            return false;
        else
            return (checkEquality(node1.getLeft(), node2.getLeft())
                    && checkEquality(node1.getRight(), node2.getRight())
                    && (node1.getValue() == node2.getValue()));
    }

    public static void main(String[] args){
        Tree tree = new Tree();
        tree.insert(50);
        tree.insert(70);
        tree.insert(40);
        tree.insert(45);
        tree.insert(35);
        tree.insert(60);
        tree.insert(80);
        System.out.print("preorder: ");
        tree.printPreOrder();
        System.out.print("postorder: ");
        tree.printPostOrder();
        System.out.print("inorder: ");
        tree.printInOrder();
        System.out.print("breadth first: ");
        tree.printBreadthFirst();
        System.out.print("depth first: ");
        tree.printDepthFirst();
        System.out.println("find: " + tree.find(45));
        System.out.println("find: " + tree.find(46));
        System.out.println("min: " + tree.findMin());
        System.out.println("max: " + tree.findMax());
        System.out.println("depth: " + tree.treeDepth());
        System.out.println("deleting an element: ");
        tree.deleteNode(40);
        tree.printInOrder();
        Tree tree2 = new Tree();
        tree2.insert(50);
        tree2.insert(70);
        tree2.insert(45);
        tree2.insert(35);
        tree2.insert(60);
        tree2.insert(80);
        System.out.println("equality: " + tree.isEqual(tree2));
    }

}