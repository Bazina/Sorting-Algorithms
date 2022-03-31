import Sorting.Sorting;
import Sorting.SortingStrategies.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static List<Integer> first, second = new ArrayList<>();
    static double start;

    public static void main(String[] args) {

        for (int size = 10000; size <= 100000; size += 1000) {
            first = Randomizer.random(size);
            System.out.println("Input : " + size);
            sort(new BubbleSort<>() , "Bubble");
            sort(new SelectionSort<>() , "Selection");
            sort(new InsertionSort<>() , "Insertion");
            sort(new HeapSort<>() , "Heap");
            sort(new MergeSort<>() , "Merge");
            sort(new QuickSort<>() , "Quick");
            System.out.println();
        }

    }

    public static void sort(SortStrategy<Integer> sortStrategy, String name) {
        second = new ArrayList<>(first) ;
        start = System.currentTimeMillis();
        Sorting.Sort(second, sortStrategy , Comparator.reverseOrder());
        System.out.println(name + " Sort : " + (System.currentTimeMillis() - start) + " ms");
    }
}
