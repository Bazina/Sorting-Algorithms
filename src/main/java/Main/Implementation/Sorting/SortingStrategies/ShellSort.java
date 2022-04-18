package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;


public class ShellSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        boolean animate = moves.isEmpty();
        Move buffer = null;

        for (int gap = toSort.size() / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < toSort.size(); i++) {

                for (int j = i; j >= gap; j -= gap) {

                    if (animate)
                        buffer = new Move(j, j - gap, (Integer) toSort.get(j), (Integer) toSort.get(j - gap), false);

                    int cmp = comparator.compare(toSort.get(j), toSort.get(j - gap));
                    if (cmp < 0) {
                        if (animate)
                            buffer.swap = true;
                        moves.add(buffer);
                        Utils.swap(toSort, j, j - gap);
                    } else {
                        moves.add(buffer);
                        break;
                    }
                }
            }
        }
    }
}
