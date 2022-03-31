import Sorting.SortingStrategies.QuickSort;
import Sorting.Sorting;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
                add(2);
                add(4);
                add(1);
                add(3);
            }
        };

        Sorting.Sort(arrayList, new QuickSort<>(), Comparator.reverseOrder());

        System.out.println(arrayList);
    }
}
