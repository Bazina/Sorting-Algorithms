package Main.Implementation.Sorting.SortingStrategies;


import Main.Controller.Move;

public class InsertionSort<T> extends SortAttributes<T> {
    @Override
    public void sort() {
        boolean animate = moves.isEmpty();
        Move buffer;

        for (int i = 1; i < toSort.size(); i++) {
            T current = toSort.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(toSort.get(j), current) > 0) {
                if (animate) {
                    buffer = new Move(j + 1, j, (Double) current, (Double) toSort.get(j), true);
                    moves.add(buffer);
                }
                toSort.set(j + 1, toSort.get(j));
                j--;
            }

            toSort.set(j + 1, current);
        }
    }
}
