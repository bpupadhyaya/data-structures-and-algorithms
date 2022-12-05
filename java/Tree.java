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

    }

}