package Sorting.SortingStrategies;

import Sorting.Utils;

import java.util.Comparator;
import java.util.List;

//comments are inspired by: https://www.geeksforgeeks.org/stooge-sort/

public class StoogeSort<T> implements SortStrategy<T> {
    @Override
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        if (arrayList.size() == 1) return;
        stoogeSort(arrayList, comparator, 0, arrayList.size()-1);
    }

    public void stoogeSort(List<T> array, Comparator<T> comparator ,int i, int j) {
        int t;
        int cmp = comparator.compare(array.get(j) , array.get( i)) ;

        // If first element is smaller
        // than last, swap them
        if (cmp < 0)
            Utils.swap( array , i , j );

        // If there are more than 2 elements
        if (( j - i + 1 ) >= 3) {
            t = ( j - i + 1 ) / 3;
            // Recursively sort first 2/3 elements
            stoogeSort( array ,  comparator, i , j - t );

            // Recursively sort last 2/3 elements
            stoogeSort( array ,  comparator, i + t , j );

            // Recursively sort first 2/3 elements
            // again to confirm
            stoogeSort( array ,  comparator, i , j - t );
        }
    }
}
