/*
Solution to Exercise 1.3.39
Author: Kinto
 */

public class RingBuffer<T> {
    private T[] buffer;
    private int head, tail;
    private final int DEFAULT_CAPACITY = 10;
    private int size;
    public RingBuffer() {
        buffer = (T[]) new Object[DEFAULT_CAPACITY];
        head = tail = size = 0;
    }
    public RingBuffer(int n) {
        buffer = (T[]) new Object[n];
        head = tail = size = 0;
    }
    public boolean enqueue(T item) {
        if (isFull()) {
            return false;
        }
        buffer[tail] = item;
        tail = (++tail) % buffer.length;
        size++;
        return true;
    }
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T temp = buffer[head];
        head = ++head % buffer.length;
        size--;
        return temp;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == buffer.length;
    }
}
