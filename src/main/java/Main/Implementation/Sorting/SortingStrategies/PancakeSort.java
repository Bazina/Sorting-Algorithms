package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;

import java.util.List;
import java.util.Queue;

public class PancakeSort<T> extends ISorting<T> {
    private boolean animate;

    @Override
    public void sort() {
        animate = moves.isEmpty();
        Move buffer = null;

        for (int i = toSort.size() - 1; i >= 0; i--) {
            int large = i;
            for (int j = 0; j < i; j++) {
                if (animate)
                    buffer = new Move(j, large, (Integer) toSort.get(j), (Integer) toSort.get(large), false);

                int cmp = comparator.compare(toSort.get(large), toSort.get(j));
                if (cmp < 0) large = j;
                moves.add(buffer);
            }
            if (large == i) continue;

            flip(toSort, large, moves, toSort);
            flip(toSort, i, moves, toSort);
        }
    }

    private void flip(List<T> arrayList, int i, Queue<Move> moves, List<T> toSort) {
        Move buffer = null;

        for (int j = 0; j <= i / 2; j++) {
            if (animate)
                buffer = new Move(j, i - j, (Integer) toSort.get(j), (Integer) toSort.get(i - j), true);

            Utils.swap(arrayList, j, i - j);
            moves.add(buffer);
        }
    }
}
