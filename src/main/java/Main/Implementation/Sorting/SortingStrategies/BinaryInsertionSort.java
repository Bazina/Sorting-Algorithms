package Main.Implementation.Sorting.SortingStrategies;

import Main.Implementation.Sorting.Utils;

import java.util.List;

public class BinaryInsertionSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        for (int i = 1; i < toSort.size(); i++) {
            int pos = binarySearch(toSort, i, toSort.get(i));
            letShift(toSort, pos, i);
        }
    }

    private int binarySearch(List<T> arrayList, int end, T val) {
        int low = 0, high = end, mid = 0;
        while (high > low) {
            mid = (high + low) / 2;
            int cmp = comparator.compare(val, arrayList.get(mid));
            if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private void letShift(List<T> arrayList, int shift, int end) {
        T temp = arrayList.get(end);
        for (int i = end; i > shift; i--) {
            Utils.swap(arrayList, i, i - 1);
        }
        arrayList.set(shift, temp);

    }
}
