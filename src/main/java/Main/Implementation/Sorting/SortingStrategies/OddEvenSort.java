package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;


//variation of bubble sort
public class OddEvenSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        boolean isSorted = false;
        int size = toSort.size();
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < size - 1; i += 2) {
                int cmp = comparator.compare(toSort.get(i), toSort.get(i + 1));
                if (cmp > 0) {
                    isSorted = false;
                    Utils.swap(toSort, i, i + 1);
                }
            }

            for (int i = 1; i < size - 1; i += 2) {
                int cmp = comparator.compare(toSort.get(i), toSort.get(i + 1));
                if (cmp > 0) {
                    isSorted = false;
                    Utils.swap(toSort, i, i + 1);
                }
            }
        }
    }
}
