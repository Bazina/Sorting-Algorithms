package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;

public class HeapSort<T extends Comparable<T>> extends SortAttributes<T> {
    boolean animate;

    @Override
    public void sort() {
        animate = moves.isEmpty();
        Move buffer = null;

        int size = toSort.size();
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i, size);
        }

        for (int i = size - 1; i > 0; i--) {
            if (animate)
                buffer = new Move(0, i, (Integer) toSort.get(0), (Integer) toSort.get(i), true);
            Utils.swap(toSort, 0, i);
            moves.add(buffer);

            heapify(0, i);
        }
    }

    private void heapify(int i, int size) {
        Move buffer = null;

        while (2 * i + 1 < size) {
            int j = 2 * i + 1;

            if (2 * i + 2 < size) {
                int cmp = comparator.compare(toSort.get(j), toSort.get(2 * i + 2));

                if (animate)
                    buffer = new Move(j, 2 * i + 2, (Integer) toSort.get(j), (Integer) toSort.get(2 * i + 2), false);
                moves.add(buffer);

                if (cmp < 0)
                    j = 2 * i + 2;
            }

            int cmp = comparator.compare(toSort.get(j), toSort.get(i));
            if (animate)
                buffer = new Move(j, i, (Integer) toSort.get(j), (Integer) toSort.get(i), false);


            if (cmp <= 0) {
                moves.add(buffer);
                break;
            }

            Utils.swap(toSort, j, i);
            if (animate)
                if (buffer != null)
                    buffer.swap = true;
            moves.add(buffer);

            i = j;
        }
    }
}
