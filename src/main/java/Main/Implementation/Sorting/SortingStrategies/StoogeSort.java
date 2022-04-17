package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;

import java.util.List;

public class StoogeSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        if (toSort.size() == 1) return;
        stoogeSort(toSort, 0, toSort.size() - 1);
    }

    public void stoogeSort(List<T> array, int i, int j) {
        int t;
        int cmp = comparator.compare(array.get(j), array.get(i));

        // If first element is smaller
        // than last, swap them
        if (cmp < 0)
            Utils.swap(array, i, j);

        // If there are more than 2 elements
        if ((j - i + 1) >= 3) {
            t = (j - i + 1) / 3;
            // Recursively sort first 2/3 elements
            stoogeSort(array, i, j - t);

            // Recursively sort last 2/3 elements
            stoogeSort(array, i + t, j);

            // Recursively sort first 2/3 elements
            // again to confirm
            stoogeSort(array, i, j - t);
        }
    }
}
