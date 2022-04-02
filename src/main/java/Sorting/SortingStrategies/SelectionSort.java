package Sorting.SortingStrategies;

import Sorting.Utils;

import java.util.Comparator;
import java.util.List;

public class SelectionSort<T> implements SortStrategy<T> {
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        for (int i = 0; i < arrayList.size(); i++) {
            int minItemIndex = i;
            for (int j = i; j < arrayList.size(); j++) {
                int cmp = comparator.compare(arrayList.get(j), arrayList.get(minItemIndex));

                if (cmp < 0)
                    minItemIndex = j;
            }

            Utils.swap(arrayList, minItemIndex, i);
        }
    }
}
