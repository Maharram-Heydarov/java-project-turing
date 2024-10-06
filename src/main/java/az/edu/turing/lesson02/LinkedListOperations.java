package az.edu.turing.lesson02;

public interface LinkedListOperations<T> {
    void addHead(T item);

    void addTail(T item);

    T removeHead();

    T removeTail();

    void insert(int index, T item);

    void update(int index, T item);

    T delete(int index);

    void delete(T item);

    void deleteAll();

    Object[] toArray();

    String toString();
}
