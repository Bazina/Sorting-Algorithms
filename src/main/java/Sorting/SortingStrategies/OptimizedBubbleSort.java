package Sorting.SortingStrategies;

import Sorting.Utils;

import java.util.Comparator;
import java.util.List;

public class OptimizedBubbleSort<T> implements SortStrategy<T> {
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        int num;
        for (int i = arrayList.size() - 1; i > 0; i -= num) {
            num = 1;
            for (int j = 0; j < i; j++) {
                int cmp = comparator.compare(arrayList.get(j), arrayList.get(j + 1));
                if (cmp > 0) {
                    Utils.swap(arrayList, j, j + 1);
                    num = 1;
                } else num++;
            }
        }
    }
}
