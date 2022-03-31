package Sorting.SortingStrategies;

import java.util.Comparator;
import java.util.List;

public interface NonComprisingSortStrategy extends SortStrategy<Integer> {
    void sort(List<Integer> arrayList, Comparator<Integer> comparator);
}
