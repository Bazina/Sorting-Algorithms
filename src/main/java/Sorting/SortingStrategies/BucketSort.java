package Sorting.SortingStrategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BucketSort<T> implements SortStrategy<T> {

    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        int bucketsNum = Collections.max(arrayList, null).hashCode() / 2;
        int i = 0;

        MergeSort<T> MergeSort = new MergeSort<>();

        if (comparator == Comparator.reverseOrder()) {
            List<List<T>> buckets = createBuckets(arrayList, bucketsNum);
            for (int j = bucketsNum - 1; j >= 0; j--) {
                MergeSort.sort(buckets.get(j), comparator);
                for (T item : buckets.get(j))
                    arrayList.set(i++, item);
            }
        } else
            for (List<T> bucket : createBuckets(arrayList, bucketsNum)) {
                MergeSort.sort(bucket, comparator);
                for (T item : bucket)
                    arrayList.set(i++, item);
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
