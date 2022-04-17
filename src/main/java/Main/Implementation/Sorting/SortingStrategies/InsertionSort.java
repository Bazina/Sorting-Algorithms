package Main.Implementation.Sorting.SortingStrategies;


public class InsertionSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        for (int i = 1; i < toSort.size(); i++) {
            T current = toSort.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(toSort.get(j), current) > 0) {
                toSort.set(j + 1, toSort.get(j));
                j--;
            }

            toSort.set(j + 1, current);
        }
    }
}
