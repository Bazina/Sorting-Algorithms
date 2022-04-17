package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Heaps.MaxHeap;

public class HeapSort<T extends Comparable<T>> extends SortAttributes<T> {
    @Override
    public void sort() {
        MaxHeap<T> heapSort = new MaxHeap<>();
        for (var item : toSort)
            heapSort.insert(item);

        for (int i = 0; i < toSort.size(); i++)
            toSort.set(i, heapSort.remove());
    }
}
