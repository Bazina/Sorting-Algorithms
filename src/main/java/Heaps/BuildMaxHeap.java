package Heaps;

import java.util.ArrayList;

public class BuildMaxHeap<T extends Comparable<T>> {
    public void buildHeap(ArrayList<T> items) {
        int lastParentIndex = items.size() / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--)
            maxHeapify(items, i);
    }

    public void maxHeapify(ArrayList<T> items, int index) {
        int largerItemIndex = index;
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        if (leftChildIndex < items.size() && items.get(leftChildIndex).compareTo(items.get(largerItemIndex)) > 0)
            largerItemIndex = leftChildIndex;

        if (rightChildIndex < items.size() && items.get(rightChildIndex).compareTo(items.get(largerItemIndex)) > 0)
            largerItemIndex = rightChildIndex;

        if (index == largerItemIndex)
            return;

        swap(items, index, largerItemIndex);
        maxHeapify(items, largerItemIndex);
    }

    private void swap(ArrayList<T> items, int first, int second) {
        T temp = items.get(first);
        items.set(first, items.get(second));
        items.set(second, temp);
    }
}

