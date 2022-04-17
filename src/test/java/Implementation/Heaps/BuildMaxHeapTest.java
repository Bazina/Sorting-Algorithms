package Implementation.Heaps;

import Main.Implementation.Heaps.BuildMaxHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BuildMaxHeapTest {
    BuildMaxHeap<Integer> buildMaxHeap = new BuildMaxHeap<>();

    @Test
    void buildHeap1() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
                add(2);
                add(4);
                add(1);
                add(3);
            }
        };

        String string = "[8, 3, 4, 1, 2]";
        buildMaxHeap.buildHeap(arrayList);

        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void buildHeap2() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
            }
        };

        String string = "[8]";
        buildMaxHeap.buildHeap(arrayList);

        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void maxHeapify1() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
                add(2);
                add(4);
                add(1);
                add(3);
            }
        };

        String string = "[8, 3, 4, 1, 2]";
        buildMaxHeap.maxHeapify(arrayList, 1);

        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void maxHeapify2() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(2);
                add(8);
                add(4);
                add(1);
                add(3);
            }
        };

        String string = "[2, 8, 4, 1, 3]";
        buildMaxHeap.maxHeapify(arrayList, 1);

        Assertions.assertEquals(string, arrayList.toString());
    }

    @Test
    void maxHeapify3() {
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                add(8);
            }
        };

        String string = "[8]";
        buildMaxHeap.maxHeapify(arrayList, 0);

        Assertions.assertEquals(string, arrayList.toString());
    }
}