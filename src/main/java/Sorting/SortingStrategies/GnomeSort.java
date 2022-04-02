package Sorting.SortingStrategies;

import Sorting.Utils;

import java.util.Comparator;
import java.util.List;

public class GnomeSort<T> implements SortStrategy<T> {
    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        int pos = 1;
        while (pos != arrayList.size()) {
            int cmp = comparator.compare(arrayList.get(pos), arrayList.get(pos - 1));
            if (cmp < 0) {
                Utils.swap(arrayList, pos, pos - 1);
                if (pos > 1) pos--;
            } else pos++;
        }
    }
}
