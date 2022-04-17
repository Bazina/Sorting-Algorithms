package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;


public class SelectionSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        for (int i = 0; i < toSort.size(); i++) {
            int minItemIndex = i;
            for (int j = i; j < toSort.size(); j++) {
                int cmp = comparator.compare(toSort.get(j), toSort.get(minItemIndex));

                if (cmp < 0)
                    minItemIndex = j;
            }

            Utils.swap(toSort, minItemIndex, i);
        }
    }
}
