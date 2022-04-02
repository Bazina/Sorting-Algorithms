package Sorting.SortingStrategies;

import Sorting.Utils;

import java.util.Comparator;
import java.util.List;

public class ShellSort<T> implements SortStrategy<T> {
    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {

        for (int gap = arrayList.size() / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arrayList.size(); i++) {

                for (int j = i; j >= gap; j -= gap) {

                    int cmp = comparator.compare(arrayList.get(j), arrayList.get(j - gap));
                    if (cmp < 0) Utils.swap(arrayList, j, j - gap);
                    else break;
                }
            }
        }
    }
}
