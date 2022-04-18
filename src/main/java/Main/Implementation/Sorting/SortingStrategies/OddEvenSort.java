package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;


//variation of bubble sort
public class OddEvenSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        boolean animate = moves.isEmpty();
        Move buffer = null;

        boolean isSorted = false;
        int size = toSort.size();
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < size - 1; i += 2) {
                if (animate)
                    buffer = new Move(i, i + 1, (Double) toSort.get(i), (Double) toSort.get(i + 1), false);

                int cmp = comparator.compare(toSort.get(i), toSort.get(i + 1));
                if (cmp > 0) {
                    if (animate)
                        buffer.swap = true;

                    isSorted = false;
                    Utils.swap(toSort, i, i + 1);
                }
                moves.add(buffer);
            }

            for (int i = 1; i < size - 1; i += 2) {
                if (animate)
                    buffer = new Move(i, i + 1, (Double) toSort.get(i), (Double) toSort.get(i + 1), false);

                int cmp = comparator.compare(toSort.get(i), toSort.get(i + 1));
                if (cmp > 0) {
                    if (animate)
                        buffer.swap = true;

                    isSorted = false;
                    Utils.swap(toSort, i, i + 1);
                }
                moves.add(buffer);
            }
        }
    }
}
