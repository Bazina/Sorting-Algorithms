package Heaps;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {
    ArrayList<T> items = new ArrayList<>();
    private int size = 0;

    /***
     * Returns true if this heap contains no elements.
     * @return true if the heap is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /***
     * Inserts new item into the heap.
     * @param value value to be inserted.
     */
    public void insert(T value) {
        items.add(value);
        size++;

        percolateUp();
    }

    /***
     * Returns and remove the root of the heap (max item).
     * @return max item in the heap.
     */
    public T remove() {
        if (isEmpty())
            throw new IllegalStateException();

        T root = items.get(0);
        items.set(0, items.get(--size));
        items.remove(size);

        percolateDown();
        return root;
    }

    /***
     * Returns max item in the heap.
     * @return max element in the heap.
     */
    public T max() {
        if (isEmpty())
            throw new IllegalStateException();

        return items.get(0);
    }

    /***
     * Maintains the heap properties by after inserting operation.
     */
    private void percolateUp() {
        T newNode = items.get(size - 1);
        int hole = size - 1;

        while (newNode.compareTo(items.get((hole - 1) / 2)) > 0 && hole > 0) {
            items.set(hole, items.get((hole - 1) / 2));

            hole = (hole - 1) / 2;
        }
        items.set(hole, newNode);
    }

    /***
     * Maintains the heap properties after deletion operation.
     */
    private void percolateDown() {
        if (size == 0)
            return;

        int child, hole = 0;
        T temp = items.get(0);

        while ((hole * 2) + 1 < size) {
            child = (hole * 2) + 1;
            int cmp;

            if (child + 1 < size) {
                cmp = compare(child + 1, child);

                if (cmp > 0)
                    child++;
            }

            cmp = compare(child, 0);
            if (cmp > 0)
                items.set(hole, items.get(child));
            else
                break;

            hole = child;
        }
        items.set(hole, temp);
    }

    /***
     * Compares two items and returns integer value which indicates if the first item is greater, smaller or equal the second item.
     * @param first first item.
     * @param second second item.
     * @return integer value which indicates if the first item is greater, smaller or equal the second item.
     */
    private int compare(int first, int second) {
        return getItem(first).compareTo(getItem(second));
    }


    /***
     * Returns item at a desired index.
     * @param index desired index.
     * @return the item at the desired index.
     */
    private T getItem(int index) {
        return items.get(index);
    }

    /***
     * Returns true if this array is a heap.
     * @param array array with integer values.
     * @return true if this array is a heap.
     */
    public static boolean isMaxHeap(int[] array) {
        return isMaxHeap(array, 0);
    }

    /***
     * Implementation of checking if the array is a max heap or not (recursive).
     * @param array array with integer values.
     * @param index index of the next item.
     * @return true if the array is a heap
     */
    private static boolean isMaxHeap(int[] array, int index) {
        int lastParentIndex = (array.length - 2) / 2;
        if (index > lastParentIndex)
            return true;

        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        boolean isValidParent = array[index] >= array[leftChildIndex] &&
                                array[index] >= array[rightChildIndex];

        return isValidParent &&
               isMaxHeap(array, leftChildIndex) &&
               isMaxHeap(array, rightChildIndex);
    }
}
