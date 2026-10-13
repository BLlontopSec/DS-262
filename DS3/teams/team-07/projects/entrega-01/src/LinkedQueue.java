public class LinkedQueue
{
    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(Object item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Student dequeue() {
        if (isEmpty()) return null;
        Student item = (Student) front.data;
        front = front.next;
        if (front == null)
            rear = null;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}