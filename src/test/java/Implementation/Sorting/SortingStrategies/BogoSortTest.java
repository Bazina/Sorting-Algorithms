package Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.SortingStrategies.BogoSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class BogoSortTest {
    BogoSort<Integer> BogoSort = new BogoSort<>();
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
            }
        };

        String string = "[8]";

        this.BogoSort.set(arrayList, moves, Comparator.reverseOrder());
        this.BogoSort.run();
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

        this.BogoSort.set(arrayList, moves, Comparator.reverseOrder());
        this.BogoSort.run();
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

        this.BogoSort.set(arrayList, moves, Comparator.naturalOrder());
        this.BogoSort.run();
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

        this.BogoSort.set(arrayList, moves, Comparator.naturalOrder());
        this.BogoSort.run();
        Assertions.assertEquals(string, arrayList.toString());
    }

}