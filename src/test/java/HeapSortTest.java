import Sorting.SortingStrategies.HeapSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;


class HeapSortTest {
    HeapSort<Integer> HeapSort = new HeapSort<>();

    @Test
    void sortTest1() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
                add(2);
                add(4);
                add(1);
                add(3);
            }
        };

        String string = "[8, 4, 3, 2, 1]";

        this.HeapSort.sort(arrayList, Comparator.reverseOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void sortTest2() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
            }
        };

        String string = "[8]";

        this.HeapSort.sort(arrayList, Comparator.reverseOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void sortTest3() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
                add(9);
            }
        };

        String string = "[9, 8]";

        this.HeapSort.sort(arrayList, Comparator.reverseOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }
}