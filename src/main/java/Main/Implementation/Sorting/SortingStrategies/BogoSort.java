package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;

import java.util.List;
import java.util.Random;

//Slow Sort-Stupid Sort-Monkey Sort
public class BogoSort<T> extends SortAttributes<T> {
    boolean animate;
    @Override
    public void sort() {
        animate = moves.isEmpty();
        while (!isSorted(toSort)) {
            shuffle(toSort);
        }
    }

    private void shuffle(List<T> arrayList) {
        Random rd = new Random();
        Move buffer;

        for (int i = 0; i < arrayList.size(); i++) {
            int index = Math.abs(rd.nextInt() % arrayList.size());
            if (animate) {
                buffer = new Move(i, index, (Integer) arrayList.get(i), (Integer) arrayList.get(index), true);
                moves.add(buffer);
            }
            Utils.swap(arrayList, i, index);
        }
    }

    private boolean isSorted(List<T> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int cmp = comparator.compare(arrayList.get(i), arrayList.get(i + 1));
            if (cmp > 0) return false;
        }
        return true;
    }
}
