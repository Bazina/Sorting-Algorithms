package SortingStrategies;

import java.util.Comparator;
import java.util.List;

public class InsertionSort<T> implements SortStrategy<T> {
    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        for (int i = 1; i < arrayList.size(); i++) {
            T current = arrayList.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(arrayList.get(j), current) > 0) {
                arrayList.set(j + 1, arrayList.get(j));
                j--;
            }

            arrayList.set(j + 1, current);
        }
    }
}
