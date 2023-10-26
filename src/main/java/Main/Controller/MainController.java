package Main.Controller;


import Main.Implementation.Sorting.Sorting;
import Main.Implementation.Sorting.SortingStrategies.ISorting;
import Main.Implementation.Sorting.SortingStrategies.MergeSort;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class MainController implements Initializable {
    private final String[] sorts = {"BinaryInsertionSort", "BitonicSort", "BogoSort", "BubbleSort",
            "CocktailShakerSort", "CombSort", "CountingSort", "DoubleSelectionSort", "GnomeSort",
            "HeapSort", "InPlaceMergeSort", "InsertionSort", "MergeSort", "OddEvenSort",
            "OptimizedBubbleSort", "PancakeSort", "QuickSort", "SelectionSort", "ShellSort", "StoogeSort"};
    CanvasUtils canvasUtils;
    @FXML
    private Canvas theCanvas;
    @FXML
    private ComboBox<String> SortComboBox;
    @FXML
    private TextField dataSize;

    @FXML
    private TextField Speed;

    private Queue<Move> moves;
    private Object sortingStrategy;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        moves = new LinkedList<>();
        SortComboBox.getItems().addAll(sorts);
        SortComboBox.setEditable(true);
        SortComboBox.styleProperty().bind(
                Bindings.when(SortComboBox.focusedProperty())
                        .then("-fx-prompt-text-fill: transparent;")
                        .otherwise("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);"));


        canvasUtils = new CanvasUtils(theCanvas);
    }


    @FXML
    private void startSorting() throws InterruptedException {
        if (canvasUtils.isSorting()) return;
        else canvasUtils.setSorting(true);

        if (SortComboBox.getValue() == null) {
            sortingStrategy = new MergeSort<>();
            SortComboBox.setValue("MergeSort");
        }

        String className = SortComboBox.getValue();
        try {
            sortingStrategy = new URLClassLoader(new URL[]{new URL("file://bin")})
                    .loadClass("Main.Implementation.Sorting.SortingStrategies." + className)
                    .getDeclaredConstructor().newInstance();

        } catch (InstantiationException | MalformedURLException | ClassNotFoundException | NoSuchMethodException |
                InvocationTargetException | IllegalAccessException e) {
            canvasUtils.setSorting(false);
            return;
        }

        canvasUtils.clear();

        int size = 50;
        if (!dataSize.getText().equals("")) size = Integer.parseInt(dataSize.getText());
        canvasUtils.setStrokeExist(size <= 200);

        if (className.equals("BitonicSort")) {
            size = nextPowerTwo(size);
            dataSize.setText(size + "");
        }

        canvasUtils.setDelay((canvasUtils.getDelay()) / Double.parseDouble(Speed.getText()));
        if (canvasUtils.getDelay() < 0.0001) canvasUtils.setDelay(0.0001);

        Random rd = new Random();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++)
            arrayList.add((int) ((Math.abs(rd.nextInt()) + 1) % theCanvas.getHeight()));

        canvasUtils.setBlockSize(theCanvas.getWidth() / arrayList.size());
        canvasUtils.setData(arrayList);
        canvasUtils.drawArray();


        Thread sort = new Thread(new Sorting(arrayList, Comparator.naturalOrder(), (ISorting<Integer>) sortingStrategy, moves));
        sort.start();

        Thread.sleep(100);
        canvasUtils.startDrawSorting(moves);
    }

    @FXML
    private void searchComboBox() {
        SortComboBox.hide();
        String search = SortComboBox.getEditor().getText();
        ArrayList<String> list = new ArrayList<>();

        if (search != null)
            SortComboBox.getItems().addAll(sorts);

        for (String sort : sorts) {
            if (search == null)
                break;
            if (sort.toLowerCase(Locale.ROOT).startsWith(search.toLowerCase(Locale.ROOT)))
                list.add(sort);
        }

        SortComboBox.getItems().clear();
        if (list.size() == 0)
            SortComboBox.getItems().addAll(sorts);
        else
            SortComboBox.getItems().addAll(list);

        SortComboBox.setVisibleRowCount((list.size() != 0) ? Math.min(list.size(), 7) : 7);

        SortComboBox.show();
    }

    private int nextPowerTwo(int size) {
        int buffer = 1;
        while (buffer * 2 < size) buffer *= 2;
        return buffer;
    }
}
