package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;


//variation of bubble sort
public class CocktailShakerSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        boolean isSorted;
        int first = 0, last = toSort.size();

        for (; first < last; first++) {
            isSorted = true;
            for (int j = first; j < last - 1; j++) {
                int cmp = comparator.compare(toSort.get(j), toSort.get(j + 1));

                if (cmp > 0) {
                    Utils.swap(toSort, j, j + 1);
                    isSorted = false;
                }
            }

            last--;
            if (isSorted)
                return;

            for (int j = last - 1; j > first; j--) {
                int cmp = comparator.compare(toSort.get(j - 1), toSort.get(j));

                if (cmp > 0) {
                    Utils.swap(toSort, j - 1, j);
                }
            }

        }
    }
}
