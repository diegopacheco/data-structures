public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
    T front();
    boolean isEmpty();
    String toString();
}