package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;

import java.util.List;

public class BinaryInsertionSort<T> extends SortAttributes<T> {
    boolean animate;

    @Override
    public void sort() {
        animate = moves.isEmpty();

        for (int i = 1; i < toSort.size(); i++) {
            int pos = binarySearch(toSort, i, toSort.get(i));
            letShift(toSort, pos, i);
        }
    }

    private int binarySearch(List<T> arrayList, int end, T val) {
        Move buffer = null;

        int low = 0, high = end, mid;
        while (high > low) {
            mid = (high + low) / 2;
            int cmp = comparator.compare(val, arrayList.get(mid));

            if (animate)
                buffer = new Move(mid, end, (Integer) toSort.get(mid), (Integer) toSort.get(end), false);
            moves.add(buffer);

            if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private void letShift(List<T> arrayList, int shift, int end) {
        Move buffer = null;

        for (int i = end; i > shift; i--) {
            if (animate)
                buffer = new Move(i, i - 1, (Integer) toSort.get(i), (Integer) toSort.get(i - 1), true);
            moves.add(buffer);

            Utils.swap(arrayList, i, i - 1);
        }
    }
}
