package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;


public class QuickSort<T> extends ISorting<T> {
    boolean animate;
    @Override
    public void sort() {
        animate = moves.isEmpty();
        sort(0, toSort.size() - 1);
    }

    private void sort(int start, int end) {
        if (start >= end)
            return;

        int boundary = partitioning(start, end);

        sort(start, boundary - 1);
        sort(boundary + 1, end);
    }

    private int partitioning(int start, int end) {
        int boundary = start - 1;
        T pivot = toSort.get(end);
        if (animate)
            moves.add(new Move(end, 0, (Integer) pivot, 0, false, true, true));

        for (int i = start; i <= end; i++) {
            if (animate)
                moves.add(new Move(i, end, (Integer) toSort.get(i), (Integer) pivot, false));

            if (comparator.compare(toSort.get(i), pivot) <= 0) {
                if (animate)
                    moves.add(new Move(i, boundary + 1, (Integer) toSort.get(i), (Integer) toSort.get(boundary + 1), true));

                Utils.swap(toSort, i, ++boundary);
            }
        }

        return boundary;
    }
}
