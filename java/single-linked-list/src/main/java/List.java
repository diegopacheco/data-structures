public interface List<T> {
    void add(T value);
    boolean remove(T value);
    boolean contains(T value);
    String toString();
}