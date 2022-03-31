package Heaps;

public class MaxPriorityQueue<T extends Comparable<T>> {
    MaxHeap<T> heap = new MaxHeap<>();

    public void enqueue(T value) {
        heap.insert(value);
    }

    public T dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}

