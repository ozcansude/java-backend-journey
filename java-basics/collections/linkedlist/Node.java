package linkedlist;

public class Node {
    String data;
    Node next;

    Node(String data)
    {
        this.setData(data);

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data;
    }
}
