package Sorting.SortingStrategies;

import Sorting.Utils;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

//Slow Sort- Stupid Sort- Monkey Sort
public class BogoSort<T> implements SortStrategy<T> {
    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        while (!isSorted(arrayList, comparator)) {
            shuffle(arrayList);
        }
    }

    private void shuffle(List<T> arrayList) {
        Random rd = new Random();

        for (int i = 0; i < arrayList.size(); i++) {
            int index = Math.abs(rd.nextInt() % arrayList.size()) ;
            Utils.swap(arrayList, i, index);
        }
    }

    private boolean isSorted(List<T> arrayList, Comparator<T> comparator) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int cmp = comparator.compare(arrayList.get(i), arrayList.get(i + 1));
            if (cmp > 0) return false;
        }
        return true;
    }
}
