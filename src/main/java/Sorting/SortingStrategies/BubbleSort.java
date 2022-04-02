package Sorting.SortingStrategies;

import Sorting.Utils;

import java.util.Comparator;
import java.util.List;

public class BubbleSort<T> implements SortStrategy<T> {
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        boolean isSorted;
        for (int i = 0; i < arrayList.size(); i++) {
            isSorted = true;
            for (int j = 1; j < arrayList.size() - i; j++) {
                int cmp = comparator.compare(arrayList.get(j - 1), arrayList.get(j));

                if (cmp > 0) {
                    Utils.swap(arrayList, j - 1, j);
                    isSorted = false;
                }
            }

            if (isSorted)
                return;
        }
    }
}
