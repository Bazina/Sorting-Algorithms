package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;

public class CombSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        boolean isSorted = false;
        int gap = toSort.size();
        while (!isSorted || gap != 1) {
            isSorted = true;
            gap = nextGap(gap);

            for (int i = 0; i + gap < toSort.size(); i++) {
                int cmp = comparator.compare(toSort.get(i), toSort.get(i + gap));
                if (cmp > 0) {
                    isSorted = false;
                    Utils.swap(toSort, i, i + gap);
                }
            }
        }
    }

    private int nextGap(int gap) {
        gap = (gap * 10) / 13;
        return (Math.max(gap, 1));
    }
}
