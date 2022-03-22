package SortingStrategies;

import java.util.Comparator;
import java.util.List;

public interface SortStrategy<T> {
    void sort(List<T> arrayList, Comparator<T> comparator);
}
