package Sorting.SortingStrategies;

import java.util.Comparator;
import java.util.List;

public class PancakeSort<T> implements SortStrategy<T> {
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        for (int i = arrayList.size()-1; i >= 0; i--) {
            int large = i ;
            for (int j = 0; j < i; j++) {
                int cmp = comparator.compare(arrayList.get(large) , arrayList.get(j)) ;
                if(cmp < 0) large = j ;
            }
            if(large == i) continue;

            flip(arrayList , large);
            flip(arrayList , i);
        }

    }

    private static <T> void flip(List<T> arrayList, int i) {
        for (int j = 0; j <= i/2; j++) {
            swap(arrayList , j , i - j);
        }
    }

    private static <T> void swap(List<T> arrayList, int first, int second) {
        T temp = arrayList.get(first);
        arrayList.set(first, arrayList.get(second));
        arrayList.set(second, temp);
    }
}
