package Sorting;

import Sorting.SortingStrategies.MergeSort;
import Sorting.SortingStrategies.SortStrategy;

import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static <T extends Comparable<T>> void Sort(List<T> arrayList) {
        new MergeSort<T>().sort(arrayList, Comparator.naturalOrder());
    }

    public static <T> void Sort(List<T> arrayList, Comparator<T> comparator) {
        new MergeSort<T>().sort(arrayList, comparator);
    }

    public static <T> void Sort(List<T> arrayList, SortStrategy<T> sortStrategy, Comparator<T> comparator) {
        sortStrategy.sort(arrayList, comparator);
    }

    public static <T extends Comparable<T>> void Sort(List<T> arrayList, SortStrategy<T> sortStrategy) {
        sortStrategy.sort(arrayList, Comparator.naturalOrder());
    }
}
