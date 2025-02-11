import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;

    @Override
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T value = top.data;
        top = top.next;
        return value;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Node<T> current = top;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(" ");
            }
            current = current.next;
        }
        return result.toString();
    }
}