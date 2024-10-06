package az.edu.turing.lesson02;

public class MyLinkedList<T> implements LinkedListOperations<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    @Override
    public void addHead(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }


    @Override
    public void addTail(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    @Override
    public T removeHead() {
        if (head == null) return null;
        T removedData = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return removedData;
    }


    @Override
    public T removeTail() {
        if (tail == null) return null;
        T removedData = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return removedData;
    }

    @Override
    public void insert(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addHead(item);
            return;
        }
        if (index == size) {
            addTail(item);
            return;
        }

        Node newNode = new Node(item);
        Node current = head;

        if (index < size / 2) {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index - 1; i--) {
                current = current.prev;
            }
        }
        newNode.next = current.next;
        current.next.prev = newNode;
        newNode.prev = current;
        current.next = newNode;
        size++;
    }


    @Override
    public void update(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = item;
    }


    @Override
    public T delete(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeHead();
        if (index == size - 1) return removeTail();

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return current.data;
    }

    @Override
    public void delete(T item) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                if (current == head) {
                    removeHead();
                } else if (current == tail) {
                    removeTail();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return;
            }
            current = current.next;
        }
    }


    @Override
    public void deleteAll() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
