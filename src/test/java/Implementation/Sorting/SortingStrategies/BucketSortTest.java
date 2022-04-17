package Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.SortingStrategies.BucketSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;


class BucketSortTest {
    BucketSort<Integer> BucketSort = new BucketSort<>();
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
                add(3);
            }
        };

        String string = "[8, 4, 3, 2, 1]";

        this.BucketSort.set(arrayList, moves, Comparator.reverseOrder());
        this.BucketSort.run();
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

        this.BucketSort.set(arrayList, moves, Comparator.reverseOrder());
        this.BucketSort.run();
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

        this.BucketSort.set(arrayList, moves, Comparator.reverseOrder());
        this.BucketSort.run();
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

        this.BucketSort.set(arrayList, moves, Comparator.naturalOrder());
        this.BucketSort.run();
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

        this.BucketSort.set(arrayList, moves, Comparator.naturalOrder());
        this.BucketSort.run();
        Assertions.assertEquals(string, arrayList.toString());
    }
}