import Sorting.SortingStrategies.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

class MergeSortTest {
    MergeSort<Integer> MergeSort = new MergeSort<>();

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

        this.MergeSort.sort(arrayList, Comparator.reverseOrder());
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

        this.MergeSort.sort(arrayList, Comparator.reverseOrder());
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

        this.MergeSort.sort(arrayList, Comparator.reverseOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void sortTest4() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
            }
        };

        String string = "[1, 2, 3, 4, 5, 6]";

        this.MergeSort.sort(arrayList, Comparator.naturalOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void sortTest5() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(6);
                add(5);
                add(4);
                add(3);
                add(2);
                add(1);
            }
        };

        String string = "[1, 2, 3, 4, 5, 6]";

        this.MergeSort.sort(arrayList, Comparator.naturalOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }
}