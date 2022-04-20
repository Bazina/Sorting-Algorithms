package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;


public class OptimizedBubbleSort<T> extends ISorting<T> {
    @Override
    public void sort() {
        int num;
        boolean isSorted;
        boolean animate = moves.isEmpty();
        Move buffer = null;

        for (int i = toSort.size() - 1; i > 0; i -= num) {
            num = 1;
            for (int j = 0; j < i; j++) {
                int cmp = comparator.compare(toSort.get(j), toSort.get(j + 1));
                if (animate)
                    buffer = new Move(j + 1, j, (Integer) toSort.get(j + 1), (Integer) toSort.get(j), false);

                if (cmp > 0) {
                    if (animate)
                        buffer.swap = true;

                    Utils.swap(toSort, j, j + 1);
                    num = 1;
                } else num++;

                moves.add(buffer);
            }
        }
    }
}
