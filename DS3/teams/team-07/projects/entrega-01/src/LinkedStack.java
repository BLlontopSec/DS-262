public class LinkedStack
{
    private Node top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(Object item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public String pop() {
        if (isEmpty()) return null;
        String item = (String) top.data;
        top = top.next;
        size--;
        return item;
    }

    public String peek() {
        if (isEmpty()) return null;
        return (String) top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}