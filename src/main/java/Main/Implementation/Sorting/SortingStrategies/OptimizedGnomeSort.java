package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;



public class OptimizedGnomeSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        boolean animate = moves.isEmpty();
        Move buffer = null;

        int pos ;
        for (int i = 1; i < toSort.size(); i++) {
            pos = i ;
            int cmp = comparator.compare(toSort.get(pos), toSort.get(pos - 1));

            while (pos > 1 && cmp < 0) {
                if(animate)
                    buffer = new Move(pos, pos - 1, (Double) toSort.get(pos), (Double) toSort.get(pos - 1), true);

                Utils.swap(toSort, pos, pos - 1);
                moves.add(buffer);
                pos--;

                cmp = comparator.compare(toSort.get(pos), toSort.get(pos - 1));
            }
        }
    }
}