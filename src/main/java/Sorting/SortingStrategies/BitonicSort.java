package Sorting.SortingStrategies;

import java.util.Comparator;
import java.util.List;

//only work with 2^k arrays
public class BitonicSort<T> implements SortStrategy<T> {

    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        bitonicSort(arrayList, comparator, 0, arrayList.size());
    }

    private void bitonicSort(List<T> arrayList, Comparator<T> comparator, int low, int cnt) {
        if (cnt <= 1) return;

        int k = cnt / 2;

        bitonicSort(arrayList, comparator, low, k);
        bitonicSort(arrayList, comparator.reversed(), low + k, k);
        bitonicMerge(arrayList, comparator, low, cnt);
    }

    private void bitonicMerge(List<T> arrayList, Comparator<T> comparator, int low, int cnt) {
        if (cnt <= 1) return;

        int k = cnt / 2;
        for (int i = low; i < low + k; i++) {
            int cmp = comparator.compare(arrayList.get(i), arrayList.get(i + k));
            if (cmp > 0) {
                swap(arrayList, i, i + k);
            }
        }

        bitonicMerge(arrayList, comparator, low, k);
        bitonicMerge(arrayList, comparator, low + k, k);
    }

    private static <T> void swap(List<T> arrayList, int first, int second) {
        T temp = arrayList.get(first);
        arrayList.set(first, arrayList.get(second));
        arrayList.set(second, temp);
    }
}