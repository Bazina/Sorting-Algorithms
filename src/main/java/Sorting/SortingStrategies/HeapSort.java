package Sorting.SortingStrategies;

import Heaps.MaxHeap;

import java.util.Comparator;
import java.util.List;

public class HeapSort<T extends Comparable<T>> implements SortStrategy<T> {
    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        MaxHeap<T> heapSort = new MaxHeap<>();
        for (var item : arrayList)
            heapSort.insert(item);

        for (int i = 0; i < arrayList.size(); i++)
            arrayList.set(i, heapSort.remove());
    }
}
