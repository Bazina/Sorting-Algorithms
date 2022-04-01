package Sorting.SortingStrategies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class GnomeSortTest {
    GnomeSort<Integer> GnomeSort = new GnomeSort<>();

    @Test
    void sortTest1() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
                add(2);
                add(4);
                add(1);
                add(30);
                add(23);
                add(33);
                add(43);
                add(9);
                add(88);
                add(13);
                add(87);
                add(3);
                add(77);
                add(2);
                add(50);
            }
        };

        String string = "[1, 2, 2, 3, 4, 8, 9, 13, 23, 30, 33, 43, 50, 77, 87, 88]";

        this.GnomeSort.sort(arrayList, Comparator.naturalOrder());
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

        this.GnomeSort.sort(arrayList, Comparator.reverseOrder());
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

        this.GnomeSort.sort(arrayList, Comparator.reverseOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void sortTest4() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(5);
                add(6);
                add(4);
                add(3);
            }
        };

        String string = "[3, 4, 5, 6]";

        this.GnomeSort.sort(arrayList, Comparator.naturalOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void sortTest5() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(5);
                add(6);
                add(4);
                add(3);
                add(10);
                add(2);
                add(7);
                add(14);
            }
        };

        String string = "[14, 10, 7, 6, 5, 4, 3, 2]";

        this.GnomeSort.sort(arrayList, Comparator.reverseOrder());
        Assertions.assertEquals(string, arrayList.toString());
    }
}