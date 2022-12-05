class Queue {
    private int[] data;
    private int size;
    private int capacity;
    private int front = 0;
    private int back = 0;

    public Queue() {
        this(50);
    }
    public Queue(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean add(int myData) {
        if (size >= capacity) {
            System.out.println("Queue overflow!");
            return false;
        } else {
            data[back++] = myData;
            back = back % capacity;
            size++;
        }
        return true;
    }

    public int remove() {
        int value;
        if (size <= 0) {
            System.out.println("Queue underflow!");
            return -1;
        } else {
            value = data[front++];
            front = front % capacity;
            size--;
        }
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        if (size == 0) {
            System.out.println("Empty queue!");
            return;
        }
        int temp = front;
        int siz = size;
        while (siz > 0) {
            System.out.print(data[temp++] + ",");
            temp = temp % capacity;
            siz--;
        }
        System.out.println();
    }

    public static void main(String... args) {
        Queue queue = new Queue();
        queue.add(5);
        queue.add(10);
        queue.add(15);
        queue.add(20);
        queue.print();
        System.out.println("size: " + queue.size());
        System.out.println("empty: " + queue.isEmpty());
        System.out.println("remove: " + queue.remove());
        queue.print();
    }
}