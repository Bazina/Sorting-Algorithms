package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;

public class BubbleSort<T> extends ISorting<T> {
    @Override
    public void sort() {
        boolean isSorted;
        boolean animate = moves.isEmpty();

        for (int i = 0; i < toSort.size(); i++) {
            isSorted = true;
            for (int j = 1; j < toSort.size() - i; j++) {
                Move buffer = null;

                int cmp = comparator.compare(toSort.get(j - 1), toSort.get(j));
                if (animate)
                    buffer = new Move(j - 1, j, (Integer) toSort.get(j - 1), (Integer) toSort.get(j), false);

                if (cmp > 0) {
                    if (animate)
                        buffer.swap = true;
                    Utils.swap(toSort, j - 1, j);
                    isSorted = false;
                }

                if (animate)
                    moves.add(buffer);
            }

            if (isSorted)
                return;
        }
    }
}
