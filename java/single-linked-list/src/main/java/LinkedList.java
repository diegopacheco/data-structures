public class LinkedList<T> implements List<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    @Override
    public boolean remove(T value) {
        if (head == null) {
            return false;
        }

        if (head.data.equals(value)) {
            head = head.next;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(value)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        Node<T> current = head;
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