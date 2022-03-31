package Sorting.SortingStrategies;

import java.util.Comparator;
import java.util.List;

public class QuickSort<T> implements SortStrategy<T> {
    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        sort(arrayList, 0, arrayList.size() - 1, comparator);
    }

    private void sort(List<T> arrayList, int start, int end, Comparator<T> comparator) {
        if (start >= end)
            return;

        int boundary = partitioning(arrayList, start, end, comparator);

        sort(arrayList, start, boundary - 1, comparator);
        sort(arrayList, boundary + 1, end, comparator);
    }

    private int partitioning(List<T> arrayList, int start, int end, Comparator<T> comparator) {
        int boundary = start - 1;
        T pivot = arrayList.get(end);

        for (int i = start; i <= end; i++) {
            if (comparator.compare(arrayList.get(i), pivot) <= 0)
                swap(arrayList, i, ++boundary);
        }

        return boundary;
    }

    private static <T> void swap(List<T> arrayList, int first, int second) {
        T temp = arrayList.get(first);
        arrayList.set(first, arrayList.get(second));
        arrayList.set(second, temp);
    }
}
