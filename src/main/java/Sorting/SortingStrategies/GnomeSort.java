package Sorting.SortingStrategies;

import java.util.Comparator;
import java.util.List;

public class GnomeSort<T> implements SortStrategy<T> {
    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        int pos = 1;
        while (pos != arrayList.size()) {
            if (pos == 0) pos++;
            int cmp = comparator.compare(arrayList.get(pos), arrayList.get(pos - 1));
            if (cmp < 0) {
                swap(arrayList, pos, pos - 1);
                pos--;
            } else pos++;
        }
    }

    private static <T> void swap(List<T> arrayList, int first, int second) {
        T temp = arrayList.get(first);
        arrayList.set(first, arrayList.get(second));
        arrayList.set(second, temp);
    }
}
