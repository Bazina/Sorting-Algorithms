package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountingSort extends SortAttributes<Integer> {
    @Override
    public void sort() {
        boolean animate = moves.isEmpty();
        if (!check(toSort))
            return;

        int maxi = Collections.max(toSort);
        int[] frequency = new int[maxi + 1];

        for (int i = 0; i < toSort.size(); i++) {
            if (animate)
                moves.add(new Move(i, 0, toSort.get(i), 0, false, true));
            frequency[toSort.get(i)]++;
        }

        int k = 0;

        if (comparator == Comparator.reverseOrder())
            for (int i = frequency.length - 1; i >= 0; i--)
                for (int j = 0; j < frequency[i]; j++) {
                    if (animate)
                        moves.add(new Move(k, 0, i, 0, false, true));
                    toSort.set(k++, i);
                }

        else
            for (int i = 0; i < frequency.length; i++)
                for (int j = 0; j < frequency[i]; j++) {
                    if (animate)
                        moves.add(new Move(k, 0, i, 0, false, true));
                    toSort.set(k++, i);
                }
    }

    private boolean check(List<Integer> arrayList) {
        for (var item : arrayList) {
            if (item < 0) {
                System.out.println("Counting sort needs array of positive integers");
                return false;
            }
        }
        return true;
    }
}
