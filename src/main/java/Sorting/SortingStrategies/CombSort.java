package Sorting.SortingStrategies;

import Sorting.Utils;

import java.util.Comparator;
import java.util.List;

public class CombSort<T> implements SortStrategy<T> {
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        boolean isSorted = false;
        int gap = arrayList.size();
        while (!isSorted || gap != 1) {
            isSorted = true;
            gap = nextGap(gap);

            for (int i = 0; i + gap < arrayList.size(); i ++) {
                int cmp = comparator.compare(arrayList.get(i), arrayList.get(i + gap));
                if (cmp > 0) {
                    isSorted = false;
                    Utils.swap(arrayList, i, i + gap);
                }
            }
        }
    }

    private int nextGap(int gap) {
        gap = (gap * 10) / 13;
        return (Math.max(gap, 1));
    }
}
