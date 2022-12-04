class Stack {
    private int[] data;
    private int size;
    private int top = -1;

    public Stack() {
        this(10);
    }

    public Stack(int size) {
        this.size = size;
        data = new int[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean push(int value) {
        if (top +1 == size) {
            System.out.println("Stack overflow!");
            return false;
        } else {
            data[++top] = value;
            return true;
        }
    }

    public int pop() {
        if(!isEmpty()) {
            int topValue = data[top];
            data[top--] = 0;
            return topValue;
        }
        return 0;
    }

    public int top() {
        if (!isEmpty()) {
            return data[top];
        }
        return 0;
    }

    public void print() {
        System.out.println("Current stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.println(data[i]+",");
        }
        System.out.println();
    }

    public static void main(String...args) {
        Stack myStack = new Stack();
        myStack.push(5);
        myStack.push(10);
        System.out.println("Popped: "+myStack.pop());
        myStack.print();
    }
}