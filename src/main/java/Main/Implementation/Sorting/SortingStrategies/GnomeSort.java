package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;


public class GnomeSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        boolean animate = moves.isEmpty();
        Move buffer = null;

        int pos = 1;
        while (pos != toSort.size()) {
            if (animate)
                buffer = new Move(pos, pos - 1, (Double) toSort.get(pos), (Double) toSort.get(pos - 1), false);

            int cmp = comparator.compare(toSort.get(pos), toSort.get(pos - 1));
            if (cmp < 0) {
                if (animate) buffer.swap = true;

                Utils.swap(toSort, pos, pos - 1);
                if (pos > 1) pos--;
            } else pos++;

            moves.add(buffer);
        }
    }
}