package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;

import java.util.List;

public class QuickSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        sort(toSort, 0, toSort.size() - 1);
    }

    private void sort(List<T> arrayList, int start, int end) {
        if (start >= end)
            return;

        int boundary = partitioning(arrayList, start, end);

        sort(arrayList, start, boundary - 1);
        sort(arrayList, boundary + 1, end);
    }

    private int partitioning(List<T> arrayList, int start, int end) {
        int boundary = start - 1;
        T pivot = arrayList.get(end);

        for (int i = start; i <= end; i++) {
            if (comparator.compare(arrayList.get(i), pivot) <= 0)
                Utils.swap(arrayList, i, ++boundary);
        }

        return boundary;
    }
}
