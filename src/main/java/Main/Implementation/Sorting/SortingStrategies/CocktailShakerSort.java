package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;


//variation of bubble sort
public class CocktailShakerSort<T> extends ISorting<T> {
    @Override
    public void sort() {
        boolean animate = moves.isEmpty();
        Move buffer = null;

        boolean isSorted;
        int first = 0, last = toSort.size();

        for (; first < last; first++) {
            isSorted = true;
            for (int j = first; j < last - 1; j++) {
                if (animate)
                    buffer = new Move(j, j + 1, (Integer) toSort.get(j), (Integer) toSort.get(j + 1), false);

                int cmp = comparator.compare(toSort.get(j), toSort.get(j + 1));
                if (cmp > 0) {
                    if (animate)
                        buffer.swap = true;

                    isSorted = false;
                    Utils.swap(toSort, j, j + 1);
                }
                moves.add(buffer);
            }

            last--;
            if (isSorted)
                return;

            for (int j = last - 1; j > first; j--) {
                if (animate)
                    buffer = new Move(j - 1, j, (Integer) toSort.get(j - 1), (Integer) toSort.get(j), false);

                int cmp = comparator.compare(toSort.get(j - 1), toSort.get(j));
                if (cmp > 0) {
                    if (animate)
                        buffer.swap = true;

                    Utils.swap(toSort, j - 1, j);
                }
                moves.add(buffer);
            }

        }
    }
}
