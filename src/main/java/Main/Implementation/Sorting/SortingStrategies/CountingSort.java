package Main.Implementation.Sorting.SortingStrategies;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountingSort extends SortAttributes<Integer> {
    @Override
    public void sort() {
        if (!check(toSort))
            return;

        int maxi = Collections.max(toSort);
        int[] frequency = new int[maxi + 1];

        for (Integer integer : toSort)
            frequency[integer]++;

        int k = 0;

        if (comparator == Comparator.reverseOrder())
            for (int i = frequency.length - 1; i >= 0; i--)
                for (int j = 0; j < frequency[i]; j++)
                    toSort.set(k++, i);

        else
            for (int i = 0; i < frequency.length; i++)
                for (int j = 0; j < frequency[i]; j++)
                    toSort.set(k++, i);
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
