package Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.SortingStrategies.InPlaceMergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class InPlaceMergeSortTest {
    InPlaceMergeSort<Integer> InPlaceMergeSort = new InPlaceMergeSort<>();
    Queue<Move> moves = new LinkedList<>() {
        {
            add(new Move(-10, -10, -10, -10, false));
        }
    };

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
                add(92);
                add(10);
            }
        };

        String string = "[1, 2, 2, 3, 4, 8, 9, 10, 13, 23, 30, 33, 43, 50, 77, 87, 88, 92]";

        this.InPlaceMergeSort.set(arrayList, moves, Comparator.naturalOrder());
        this.InPlaceMergeSort.run();
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

        this.InPlaceMergeSort.set(arrayList, moves, Comparator.reverseOrder());
        this.InPlaceMergeSort.run();
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

        this.InPlaceMergeSort.set(arrayList, moves, Comparator.reverseOrder());
        this.InPlaceMergeSort.run();
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

        this.InPlaceMergeSort.set(arrayList, moves, Comparator.naturalOrder());
        this.InPlaceMergeSort.run();
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
                add(1);
            }
        };

        String string = "[14, 10, 7, 6, 5, 4, 3, 2, 1]";

        this.InPlaceMergeSort.set(arrayList, moves, Comparator.reverseOrder());
        this.InPlaceMergeSort.run();
        Assertions.assertEquals(string, arrayList.toString());
    }
}