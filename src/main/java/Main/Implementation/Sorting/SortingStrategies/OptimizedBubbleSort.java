package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;


public class OptimizedBubbleSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        int num;
        for (int i = toSort.size() - 1; i > 0; i -= num) {
            num = 1;
            for (int j = 0; j < i; j++) {
                int cmp = comparator.compare(toSort.get(j), toSort.get(j + 1));
                if (cmp > 0) {
                    Utils.swap(toSort, j, j + 1);
                    num = 1;
                } else num++;
            }
        }
    }
}
