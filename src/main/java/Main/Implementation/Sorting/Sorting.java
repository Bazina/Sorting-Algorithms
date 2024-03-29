package Main.Implementation.Sorting;

import Main.Controller.Move;
import Main.Implementation.Sorting.SortingStrategies.MergeSort;
import Main.Implementation.Sorting.SortingStrategies.ISorting;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class Sorting implements Runnable {
    List<Integer> toSort;
    Comparator<Integer> comparator;
    ISorting<Integer> sort;
    Queue<Move> moves;

    public Sorting(List<Integer> toSort, Comparator<Integer> comparator,
                   ISorting<Integer> sort, Queue<Move> moves) {
        this.toSort = toSort;
        this.comparator = comparator;
        this.sort = sort;
        this.moves = moves;
    }

    public Sorting() {
    }

    //using default sort -merge sort- with default order -ascending-
    public static <T extends Comparable<T>> void Sort(List<T> arrayList) {
        ISorting<T> sort = new MergeSort<>();
        sort.set(arrayList, null, Comparator.naturalOrder());
        sort.run();
    }

    //using default sort -merge sort-with specific order
    public static <T> void Sort(List<T> arrayList, Comparator<T> comparator) {
        ISorting<T> sort = new MergeSort<>();
        sort.set(arrayList, null, comparator);
        sort.run();
    }

    //using specific sort with specific order
    public static <T> void Sort(List<T> arrayList, ISorting<T> sort,
                                Comparator<T> comparator, Queue<Move> moves) {
        sort.set(arrayList, moves, comparator);
        sort.run();
    }

    //using specific sort with default order -ascending-
    public static <T extends Comparable<T>> void Sort(List<T> arrayList, ISorting<T> sort) {
        sort.set(arrayList, null, Comparator.naturalOrder());
        sort.run();
    }

    //using specific sort with specific order (Thread)
    public <T> void ThreadSort(List<T> arrayList, ISorting<T> sort,
                               Comparator<T> comparator, Queue<Move> moves) {
        sort.set(arrayList, moves, comparator);
        sort.run();
    }

    @Override
    public void run() {
        ThreadSort(toSort, sort, comparator, moves);
    }
}
