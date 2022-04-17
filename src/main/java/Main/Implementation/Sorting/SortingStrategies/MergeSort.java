package Main.Implementation.Sorting.SortingStrategies;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        sort(toSort);
    }

    public void sort(List<T> toSort) {
        if (toSort.size() <= 1)
            return;

        int middle = toSort.size() / 2;

        List<T> left = new ArrayList<>(middle);
        List<T> right = new ArrayList<>(toSort.size() - middle);

        for (int i = 0; i < middle; i++) {
            left.add(toSort.get(i));
        }

        for (int i = middle; i < toSort.size(); i++) {
            right.add(toSort.get(i));
        }

        sort(left);
        sort(right);

        merge(toSort, left, right);
    }

    private void merge(List<T> arrayList, List<T> left, List<T> right) {
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
