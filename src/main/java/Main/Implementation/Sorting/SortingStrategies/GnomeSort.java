package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;


public class GnomeSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        int pos = 1;
        while (pos != toSort.size()) {
            int cmp = comparator.compare(toSort.get(pos), toSort.get(pos - 1));
            if (cmp < 0) {
                Utils.swap(toSort, pos, pos - 1);
                if (pos > 1) pos--;
            } else pos++;
        }
    }
}
