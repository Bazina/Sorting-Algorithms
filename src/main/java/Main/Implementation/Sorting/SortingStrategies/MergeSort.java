package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T> extends ISorting<T> {
    boolean animate;
    private List<T> temp;

    @Override
    public void sort() {
        animate = moves.isEmpty();
        temp = new ArrayList<>(toSort);
        sort(0, toSort.size() - 1);
    }

    private void sort(int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            sort(low, middle);
            sort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        Move buffer;
        for (int i = low; i <= high; i++) {
            temp.set(i, toSort.get(i));
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (comparator.compare(temp.get(i), temp.get(j)) < 0) {
                if (animate) {
                    buffer = new Move(i, j, (Integer) temp.get(i), (Integer) temp.get(j), false, false);
                    moves.add(buffer);
                }
                toSort.set(k++, temp.get(i++));
            } else {
                if (animate) {
                    buffer = new Move(i, j, (Integer) temp.get(i), (Integer) temp.get(j), false, false);
                    moves.add(buffer);
                }
                toSort.set(k++, temp.get(j++));
            }
        }

        if (animate)
            for (int l = low; l < k; l++) {
                buffer = new Move(l, 0, (Integer) toSort.get(l), 0, false, true);
                moves.add(buffer);
            }

        while (i <= middle) {
            if (animate) {
                buffer = new Move(k, 0, (Integer) temp.get(i), 0, false, true);
                moves.add(buffer);
            }
            toSort.set(k++, temp.get(i++));
        }

        while (j <= high) {
            if (animate) {
                buffer = new Move(k, 0, (Integer) temp.get(j), 0, false, true);
                moves.add(buffer);
            }
            toSort.set(k++, temp.get(j++));
        }
    }
}
