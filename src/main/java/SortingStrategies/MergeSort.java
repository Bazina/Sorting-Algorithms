package SortingStrategies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T> implements SortStrategy<T> {
    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        if (arrayList.size() <= 1)
            return;

        int middle = arrayList.size() / 2;

        List<T> left = new ArrayList<>(middle);
        List<T> right = new ArrayList<>(arrayList.size() - middle);

        for (int i = 0; i < middle; i++) {
            left.add(arrayList.get(i));
        }

        for (int i = middle; i < arrayList.size(); i++) {
            right.add(arrayList.get(i));
        }

        sort(left, comparator);
        sort(right, comparator);

        merge(arrayList, left, right, comparator);
    }

    private void merge(List<T> arrayList, List<T> left, List<T> right, Comparator<T> comparator) {
        int j = 0, i = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) < 0)
                arrayList.set(k++, left.get(i++));
            else
                arrayList.set(k++, right.get(j++));
        }

        while (i < left.size())
            arrayList.set(k++, left.get(i++));

        while (j < right.size())
            arrayList.set(k++, right.get(j++));
    }
}
