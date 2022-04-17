import Sorting.Sorting;
import Sorting.SortingStrategies.*;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static List<Integer> first, second = new ArrayList<>();
    static double start;
    static CSVWriter writer;

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/Data.csv");
        FileWriter outputFile = new FileWriter(file);
        writer = new CSVWriter(outputFile);

        String[] header = {"Input Size", "Bubble Sort", "Pancake Sort","Optimized Bubble Sort" ,"Odd Even Sort" ,
                "Cocktail Shaker", "Gnome Sort", "Selection Sort","Binary Insertion Sort",
                "Insertion Sort", "Double Selection Sort", "Comb Sort" ,"Shell Sort",
                "Heap Sort", "In Place Merge Sort","Merge Sort", "Quick Sort"};
        writer.writeNext(header);

        for (int size = 10000; size <= 40000; size += 1000) {
            first = Randomizer.random(size);
            System.out.println("Input: " + size);
//            double bogoSort = sort(new BogoSort<>() , "Bogo") ;
//            double stoogeTime = sort(new StoogeSort<>() , "Stooge") ;
            double bubbleTime = sort(new BubbleSort<>(), "Bubble");
            double pancakeTime = sort(new PancakeSort<>(), "Pancake");
            double optimizedBubbleTime = sort(new OptimizedBubbleSort<>() , "Optimized Bubble") ;
            double oddEvenTime = sort(new OddEvenSort<>() , "Odd Even") ;
            double cocktailShakerTime = sort(new CocktailShakerSort<>(), "Cocktail Shaker");
            double gnomeTime = sort(new GnomeSort<>(), "Gnome");
            double selectionTime = sort(new SelectionSort<>(), "Selection");
            double binaryInsertionTime = sort(new BinaryInsertionSort<>() , "Binary Insertion") ;
            double insertionTime = sort(new InsertionSort<>(), "Insertion");
            double doubleSelectionTime = sort(new DoubleSelectionSort<>(), "Double Selection");
            double combTime = sort(new CombSort<>() , "Comb") ;
            double shellTime = sort(new ShellSort<>(), "Shell");
            double heapTime = sort(new HeapSort<>(), "Heap");
            double inPlaceMergeTime = sort(new InPlaceMergeSort<>() , "In Place Merge") ;
            double mergeTime = sort(new MergeSort<>(), "Merge");
            double quickTime = sort(new QuickSort<>(), "Quick");

            String[] data = {String.valueOf(size), String.valueOf(bubbleTime), String.valueOf(pancakeTime),String.valueOf(optimizedBubbleTime),String.valueOf(oddEvenTime),
                    String.valueOf(cocktailShakerTime), String.valueOf(gnomeTime), String.valueOf(selectionTime),String.valueOf(binaryInsertionTime),
                    String.valueOf(insertionTime), String.valueOf(doubleSelectionTime),String.valueOf(combTime) , String.valueOf(shellTime),
                    String.valueOf(heapTime),String.valueOf(inPlaceMergeTime), String.valueOf(mergeTime), String.valueOf(quickTime)};
            writer.writeNext(data);

            System.out.println();
        }
        writer.close();
    }

    public static double sort(SortStrategy<Integer> sortStrategy, String name) {
        second = new ArrayList<>(first);
        start = System.currentTimeMillis();
        Sorting.Sort(second, sortStrategy, Comparator.reverseOrder());

        double time = System.currentTimeMillis() - start;
        System.out.println(name + " Sort: " + time + " ms");

        return time;
    }
}
