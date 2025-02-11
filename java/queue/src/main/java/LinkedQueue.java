import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;
    private Node<T> rear;

    @Override
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Queue: [");
        Node<T> current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }
}