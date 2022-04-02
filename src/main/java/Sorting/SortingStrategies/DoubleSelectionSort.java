package Sorting.SortingStrategies;

import java.util.Comparator;
import java.util.List;

//also named as cocktail sort due to its similarity to cocktail shaker sort
public class DoubleSelectionSort<T> implements SortStrategy<T> {
    private static <T> void swap(List<T> arrayList, int first, int second) {
        T temp = arrayList.get(first);
        arrayList.set(first, arrayList.get(second));
        arrayList.set(second, temp);
    }

    public void sort(List<T> arrayList, Comparator<T> comparator) {
        int n = arrayList.size();
        for (int i = 0; i < n; i++) {
            int minItemIndex = i;
            int maxItemIndex = i;
            T maxVal = arrayList.get(i);

            for (int j = i; j < n; j++) {
                int cmp1 = comparator.compare(arrayList.get(j), arrayList.get(minItemIndex));
                int cmp2 = comparator.compare(arrayList.get(j), arrayList.get(maxItemIndex));

                if (cmp1 < 0)
                    minItemIndex = j;
                else if (cmp2 > 0) {
                    maxVal = arrayList.get(j);
                    maxItemIndex = j;
                }
            }

            //when i==maxItemIndex we need to keep track of maximum element after first swapping
            if (arrayList.get(i) == maxVal) maxItemIndex = minItemIndex;

            swap(arrayList, minItemIndex, i);
            swap(arrayList, maxItemIndex, n - 1);
            n--;
        }
    }
}
