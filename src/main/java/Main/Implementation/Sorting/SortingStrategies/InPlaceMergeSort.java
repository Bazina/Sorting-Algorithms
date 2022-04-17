package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;

import java.util.List;

public class InPlaceMergeSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        mergeSort(toSort, 0, toSort.size() - 1);
    }

    private void mergeSort(List<T> arrayList, int low, int high) {
        if (high - low < 1)
            return;

        int mid = (high + low) / 2;

        mergeSort(arrayList, low, mid);
        mergeSort(arrayList, mid + 1, high);

        mergeArray(arrayList, low, high);
    }

    private void mergeArray(List<T> arrayList, int low, int high) {
        for (int gap = (high - low + 1) / 2; gap > 0; gap /= 2) {

            for (int i = low + gap; i < high + 1; i++) {

                for (int j = i; j >= gap + low; j -= gap) {

                    int cmp = comparator.compare(arrayList.get(j), arrayList.get(j - gap));
                    if (cmp < 0) Utils.swap(arrayList, j, j - gap);
                    else break;
                }
            }
        }
    }
}
