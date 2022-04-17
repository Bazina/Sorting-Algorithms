package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;

import java.util.List;

public class PancakeSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        for (int i = toSort.size() - 1; i >= 0; i--) {
            int large = i;
            for (int j = 0; j < i; j++) {
                int cmp = comparator.compare(toSort.get(large), toSort.get(j));
                if (cmp < 0) large = j;
            }
            if (large == i) continue;

            flip(toSort, large);
            flip(toSort, i);
        }

    }

    private static <T> void flip(List<T> arrayList, int i) {
        for (int j = 0; j <= i / 2; j++) {
            Utils.swap(arrayList, j, i - j);
        }
    }
}
