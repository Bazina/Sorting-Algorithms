package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;

public class CombSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        boolean animate = moves.isEmpty();
        Move buffer = null;

        boolean isSorted = false;
        int gap = toSort.size();
        while (!isSorted || gap != 1) {
            isSorted = true;
            gap = nextGap(gap);

            for (int i = 0; i + gap < toSort.size(); i++) {
                if (animate)
                    buffer = new Move(i, i + gap, (Double) toSort.get(i), (Double) toSort.get(i + gap), false);

                int cmp = comparator.compare(toSort.get(i), toSort.get(i + gap));
                if (cmp > 0) {
                    if(animate) buffer.swap = true ;

                    isSorted = false;
                    Utils.swap(toSort, i, i + gap);
                }

                moves.add(buffer) ;
            }
        }
    }

    private int nextGap(int gap) {
        gap = (gap * 10) / 13;
        return (Math.max(gap, 1));
    }
}
