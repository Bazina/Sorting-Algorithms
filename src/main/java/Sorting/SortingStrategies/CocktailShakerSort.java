package Sorting.SortingStrategies;

import java.util.Comparator;
import java.util.List;

public class CocktailShakerSort<T> implements SortStrategy<T> {
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        boolean isSorted;
        int first = 0, last = arrayList.size();

        for (; first < last; first++) {
            isSorted = true;
            for (int j = first; j < last - 1; j++) {
                int cmp = comparator.compare(arrayList.get(j), arrayList.get(j + 1));

                if (cmp > 0) {
                    swap(arrayList, j, j + 1);
                    isSorted = false;
                }
            }

            last--;
            if (isSorted)
                return;

            for (int j = last - 1; j > first; j--) {
                int cmp = comparator.compare(arrayList.get(j - 1), arrayList.get(j));

                if (cmp > 0) {
                    swap(arrayList, j - 1, j);
                }
            }

        }
    }

    private static <T> void swap(List<T> arrayList, int first, int second) {
        T temp = arrayList.get(first);
        arrayList.set(first, arrayList.get(second));
        arrayList.set(second, temp);
    }
}
