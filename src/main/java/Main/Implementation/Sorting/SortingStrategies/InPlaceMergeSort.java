package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.Utils;

import java.util.List;

public class InPlaceMergeSort<T> extends SortAttributes<T> {
    private boolean animate;

    @Override
    public void sort() {
        animate = moves.isEmpty();
        mergeSort(toSort, 0, toSort.size() - 1);
    }

    private void mergeSort(List<T> arrayList, int low, int high) {
        if (high - low < 1)
            return;

        int mid = (high + low) / 2;

        mergeSort(arrayList, low, mid);
        mergeSort(arrayList, mid + 1, high);

        mergeArray(arrayList, low, high);
    }

    //using Shell Sort
    private void mergeArray(List<T> arrayList, int low, int high) {
        Move buffer = null;

        for (int gap = (high - low + 1) / 2; gap > 0; gap /= 2) {

            for (int i = low + gap; i < high + 1; i++) {

                for (int j = i; j >= gap + low; j -= gap) {
                    if (animate)
                        buffer = new Move(j, j - gap, (Integer) toSort.get(j), (Integer) toSort.get(j - gap), false);

                    int cmp = comparator.compare(arrayList.get(j), arrayList.get(j - gap));
                    if (cmp < 0) {
                        Utils.swap(arrayList, j, j - gap);
                        if (animate)
                            if (buffer != null)
                                buffer.swap = true;

                        moves.add(buffer);
                    } else {
                        moves.add(buffer);
                        break;
                    }
                }
            }
        }
    }
}
