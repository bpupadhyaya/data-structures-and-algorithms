
class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class LinkedList {
    private Node head;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addHead(int value) {
        head = new Node(value, head);
        size++;
    }

    public void addTail(int value) {
        Node newNode = new Node(value, null);
        Node curr = head;
        if (head == null) {
            head = newNode;
        }
        while ( curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(newNode);
        size++;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty linked list! ");
        }
        return head.getValue();
    }

    public int removeHead() {
        if (isEmpty()) {
            System.out.println("Empty linked list! ");
        }
        int value = head.getValue();
        head = head.getNext();
        size--;
        return value;
    }

    public boolean find(int value) {
        Node temp = head;

        while (temp != null) {
            if (temp.getValue() == value) {
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    public boolean deleteNode(int data) {
        Node temp = head;

        if (isEmpty())
            return false;

        if (data == head.getValue()) {
            head = head.getNext();
            size--;
            return true;
        }

        while (temp.getNext() != null) {
            if (temp.getNext().getValue() == data) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public int len() {
        Node curr = head;
        int count = 0;

        while (curr != null) {
            count++;
            curr.setNext(curr.getNext());
        }
        return count;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.getValue() + ",");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linList = new LinkedList();
        linList.addHead(5);
        linList.addTail(6);
        linList.addTail(7);
        System.out.print("Linked llist: ");
        linList.print();
        linList.reverse();
        System.out.print("Reversed llist: ");
        linList.print();
        linList.size();
        System.out.println("delete: " + linList.deleteNode(6));
        linList.print();
        System.out.println("size: " + linList.size());
        System.out.println("find: " + linList.find(6));
        linList.addHead(10);
        linList.addTail(15);
        System.out.print("New llist: ");
        linList.print();
        linList.removeHead();
        System.out.print("Head removed: ");
        linList.print();
        System.out.println("Peek: " + linList.peek());
        System.out.println("size: " + linList.size());
    }
}