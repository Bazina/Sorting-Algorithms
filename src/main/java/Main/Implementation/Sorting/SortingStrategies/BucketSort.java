package Main.Implementation.Sorting.SortingStrategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BucketSort<T> extends ISorting<T> {

    @Override
    public void sort() {
        int bucketsNum = Collections.max(toSort, null).hashCode() / 2;
        int i = 0;

        MergeSort<T> MergeSort = new MergeSort<>();

        if (comparator == Comparator.reverseOrder()) {
            List<List<T>> buckets = createBuckets(toSort, bucketsNum);
            for (int j = bucketsNum - 1; j >= 0; j--) {
                MergeSort.set(buckets.get(j), moves, comparator);
                MergeSort.run();
                for (T item : buckets.get(j))
                    toSort.set(i++, item);
            }
        } else
            for (List<T> bucket : createBuckets(toSort, bucketsNum)) {
                MergeSort.set(bucket, moves, comparator);
                MergeSort.run();
                for (T item : bucket)
                    toSort.set(i++, item);
            }
    }

    private List<List<T>> createBuckets(List<T> arrayList, int bucketsNum) {
        List<List<T>> buckets = new ArrayList<>();

        for (int i = 0; i < bucketsNum; i++)
            buckets.add(new ArrayList<>());

        for (T item : arrayList)
            buckets.get(item.hashCode() / bucketsNum).add(item);

        return buckets;
    }
}
