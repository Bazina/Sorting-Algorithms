package Sorting.SortingStrategies;

import java.util.Comparator;
import java.util.List;

public class ShellSort<T> implements SortStrategy<T> {
    private static <T> void swap(List<T> arrayList, int first, int second) {
        T temp = arrayList.get(first);
        arrayList.set(first, arrayList.get(second));
        arrayList.set(second, temp);
    }

    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {

        for (int gap = arrayList.size() / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arrayList.size(); i++) {

                for (int j = i; j >= gap; j -= gap) {

                    int cmp = comparator.compare(arrayList.get(j), arrayList.get(j - gap));
                    if (cmp < 0) swap(arrayList, j, j - gap);
                    else break;
                }
            }
        }
    }
}
