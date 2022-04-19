package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;

import java.util.Comparator;
import java.util.List;

//only work with 2^k arrays
public class BitonicSort<T> extends SortAttributes<T> {

    @Override
    public void sort() {
        boolean animate = moves.isEmpty();

        bitonicSort(toSort, comparator, 0, toSort.size());
    }

    private void bitonicSort(List<T> arrayList, Comparator<T> comparator, int low, int cnt) {
        if (cnt <= 1) return;

        int k = cnt / 2;

        bitonicSort(arrayList, comparator, low, k);
        bitonicSort(arrayList, comparator.reversed(), low + k, k);
        bitonicMerge(arrayList, comparator, low, cnt);
    }

    private void bitonicMerge(List<T> arrayList, Comparator<T> comparator, int low, int cnt) {
        if (cnt <= 1) return;

        Move buffer = null ;

        int k = cnt / 2;
        for (int i = low; i < low + k; i++) {
            int cmp = comparator.compare(arrayList.get(i), arrayList.get(i + k));
            buffer =  new Move(i, i + k, (Integer) toSort.get(i), (Integer) toSort.get(i + k), false);

            if (cmp > 0) {
                buffer.swap = true ;
                moves.add(buffer) ;
                Utils.swap(arrayList, i, i + k);
            }
        }

        bitonicMerge(arrayList, comparator, low, k);
        bitonicMerge(arrayList, comparator, low + k, k);
    }
}