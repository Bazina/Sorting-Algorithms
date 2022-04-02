package Sorting.SortingStrategies;

import Sorting.Utils;

import java.util.Comparator;
import java.util.List;

//variation of bubble sort
public class OddEvenSort<T> implements SortStrategy<T> {
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        boolean isSorted = false;
        int size = arrayList.size();
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < size - 1; i += 2) {
                int cmp = comparator.compare(arrayList.get(i), arrayList.get(i + 1));
                if (cmp > 0) {
                    isSorted = false;
                    Utils.swap(arrayList, i, i + 1);
                }
            }

            for (int i = 1; i < size - 1; i += 2) {
                int cmp = comparator.compare(arrayList.get(i), arrayList.get(i + 1));
                if (cmp > 0) {
                    isSorted = false;
                    Utils.swap(arrayList, i, i + 1);
                }
            }
        }
    }
}
