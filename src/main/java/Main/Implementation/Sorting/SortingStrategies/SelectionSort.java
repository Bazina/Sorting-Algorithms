package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;


public class SelectionSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        boolean animate = moves.isEmpty();
        Move buffer;

        for (int i = 0; i < toSort.size(); i++) {
            int minItemIndex = i;
            for (int j = i; j < toSort.size(); j++) {
                int cmp = comparator.compare(toSort.get(j), toSort.get(minItemIndex));
                if (animate) {
                    buffer = new Move(j, minItemIndex, (Integer) toSort.get(j), (Integer) toSort.get(minItemIndex), false);
                    moves.add(buffer);
                }
                if (cmp < 0)
                    minItemIndex = j;
            }

            if (animate) {
                buffer = new Move(i, minItemIndex, (Integer) toSort.get(i), (Integer) toSort.get(minItemIndex), true);
                moves.add(buffer);
            }
            Utils.swap(toSort, minItemIndex, i);
        }
    }
}
