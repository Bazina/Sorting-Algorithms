package Main.Implementation.Sorting.SortingStrategies;

import Main.Controller.Move;
import Main.Implementation.Sorting.SortStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public abstract class ISorting<T> implements SortStrategy, Runnable {
    List<T> toSort;
    Queue<Move> moves;
    Comparator<T> comparator;

    public void set(List<T> toSort, Queue<Move> moves, Comparator<T> comparator) {
        this.toSort = toSort;
        this.moves = moves;
        this.comparator = comparator;
    }

    @Override
    public void run() {
        sort();
    }
}
