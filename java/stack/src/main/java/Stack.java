public interface Stack<T> {
    void push(T value);
    T pop();
    T top();
    boolean isEmpty();
    String toString();
}