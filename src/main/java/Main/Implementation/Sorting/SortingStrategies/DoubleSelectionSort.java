package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;

import java.util.List;

//also named as cocktail sort due to its similarity to cocktail shaker sort
public class DoubleSelectionSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        int n = toSort.size();
        boolean animate = moves.isEmpty();
        Move buffer1, buffer2;
        for (int i = 0; i < n; i++) {
            int minItemIndex = i;
            int maxItemIndex = i;
            T maxVal = toSort.get(i);

            for (int j = i; j < n; j++) {
                int cmp1 = comparator.compare(toSort.get(j), toSort.get(minItemIndex));
                int cmp2 = comparator.compare(toSort.get(j), toSort.get(maxItemIndex));
                if (animate) {
                    buffer1 = new Move(j, minItemIndex, (Integer) toSort.get(j), (Integer) toSort.get(minItemIndex), false);
                    buffer2 = new Move(j, maxItemIndex, (Integer) toSort.get(j), (Integer) toSort.get(maxItemIndex), false);
                    moves.add(buffer1);
                    moves.add(buffer2);
                }

                if (cmp1 < 0) {
                    minItemIndex = j;
                } else if (cmp2 > 0) {
                    maxVal = toSort.get(j);
                    maxItemIndex = j;
                }
            }

            // When i==maxItemIndex we need to keep track of maximum element after first swapping
            if (toSort.get(i) == maxVal)
                maxItemIndex = minItemIndex;

            if (animate) {
                buffer1 = new Move(i, minItemIndex, (Integer) toSort.get(i), (Integer) toSort.get(minItemIndex), true);
                buffer2 = new Move(n - 1, maxItemIndex, (Integer) toSort.get(n - 1), (Integer) toSort.get(maxItemIndex), true);
                moves.add(buffer1);
                moves.add(buffer2);
            }
            swap(toSort, minItemIndex, i);
            swap(toSort, maxItemIndex, n - 1);
            n--;
        }
    }

    private static <T> void swap(List<T> arrayList, int first, int second) {
        T temp = arrayList.get(first);
        arrayList.set(first, arrayList.get(second));
        arrayList.set(second, temp);
    }
}
