package Sorting.SortingStrategies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

class BogoSortTest {
    BogoSort<Integer> BogoSort = new BogoSort<>();

    @Test
    void sortTest1() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
            }
        };

        String string = "[8]";

        this.BogoSort.sort(arrayList, Comparator.reverseOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void sortTest2() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
                add(9);
            }
        };

        String string = "[9, 8]";

        this.BogoSort.sort(arrayList, Comparator.reverseOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void sortTest3() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(4);
                add(6);
                add(2);
            }
        };

        String string = "[2, 4, 6]";

        this.BogoSort.sort(arrayList, Comparator.naturalOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void sortTest4() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(10);
                add(4);
                add(6);
                add(2);
            }
        };

        String string = "[2, 4, 6, 10]";

        this.BogoSort.sort(arrayList, Comparator.naturalOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }

}