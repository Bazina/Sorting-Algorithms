package Main;


import Main.Controller.Move;
import Main.Implementation.Sorting.Sorting;
import Main.Implementation.Sorting.SortingStrategies.MergeSort;
import Main.Implementation.Sorting.SortingStrategies.SortAttributes;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class MainController implements Initializable {
    @FXML
    private Canvas theCanvas;
    @FXML
    private ComboBox<String> SortComboBox;
    @FXML
    private TextField dataSize;
    @FXML
    private TextField Delay;

    private double blockSize;

    private GraphicsContext gc;
    private List<Integer> arrayList;

    private Queue<Move> moves;

    private Object sortingStrategy;
    private double delay = 0.01;
    private boolean strokeExist = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        moves = new LinkedList<>();
        SortComboBox.getItems().addAll("BinaryInsertionSort", "BitonicSort", "BogoSort", "BubbleSort",
                "CocktailShakerSort", "CombSort", "CountingSort", "DoubleSelectionSort", "GnomeSort",
                "HeapSort", "InPlaceMergeSort", "InsertionSort", "MergeSort", "OddEvenSort",
                "OptimizedBubbleSort", "PancakeSort", "QuickSort", "SelectionSort", "ShellSort", "StoogeSort");

        Delay.setText("0.01");

        SortComboBox.setVisibleRowCount(7);
        theCanvas.setScaleY(-1);

        gc = theCanvas.getGraphicsContext2D();
    }

    private void drawArray() {
        gc.setFill(Color.BLACK);

        if (strokeExist) gc.setStroke(Color.rgb(244, 244, 244));
        else gc.setStroke(Color.BLACK);

        for (int i = 0; i < arrayList.size(); i++) {
            gc.fillRect(i * blockSize, 0, blockSize, arrayList.get(i));
            gc.strokeRect(i * blockSize, 0, blockSize, arrayList.get(i));
        }
    }

    @FXML
    private void startSorting() throws InterruptedException {
        if (sortingStrategy == null) {
            sortingStrategy = new MergeSort<>();
            SortComboBox.setValue("MergeSort");
        }

        gc.clearRect(0, 0, theCanvas.getWidth(), theCanvas.getHeight());

        int size = 50;

        if (!dataSize.getText().equals("")) size = Integer.parseInt(dataSize.getText());

        delay = Double.parseDouble(Delay.getText());

        strokeExist = size <= 200;

        Random rd = new Random();
        arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++)
            arrayList.add((int) ((Math.abs(rd.nextInt()) + 1) % theCanvas.getHeight()));

        blockSize = theCanvas.getWidth() / arrayList.size();
        drawArray();


        String className = SortComboBox.getValue();

        try {
            sortingStrategy = new URLClassLoader(new URL[]{new URL("file://bin")})
                    .loadClass("Main.Implementation.Sorting.SortingStrategies." + className)
                    .getDeclaredConstructor().newInstance();

        } catch (InstantiationException | MalformedURLException | ClassNotFoundException | NoSuchMethodException |
                 InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


        Thread sort = new Thread(new Sorting(arrayList, Comparator.naturalOrder(), (SortAttributes<Integer>) sortingStrategy, moves));
        sort.start();

        Thread.sleep(100);
        startDrawSorting();
    }

    private void startDrawSorting() {
        Timeline timeline1;
        Timeline timeline2;

        if (moves.isEmpty()) return;

        Move current = moves.poll();
        if (current.pivot) timeline1 = coloredTimeLine(current, Color.GOLD);
        else timeline1 = coloredTimeLine(current, Color.RED);

        gc.setFill(Color.BLACK);
        timeline2 = coloredTimeLine(current, Color.BLACK);
        Timeline finalTimeline = timeline2;
        timeline1.setOnFinished(e -> finalTimeline.play());

        timeline1.play();

        while (!moves.isEmpty()) {
            current = moves.poll();

            if (current.pivot) timeline1 = coloredTimeLine(current, Color.GOLD);
            else timeline1 = coloredTimeLine(current, Color.RED);

            Timeline finalTimeline1 = timeline1;
            timeline2.setOnFinished(e -> finalTimeline1.play());

            timeline2 = coloredTimeLine(current, Color.BLACK);
            Timeline finalTimeline2 = timeline2;
            timeline1.setOnFinished(e -> finalTimeline2.play());
        }
        timeline2.setOnFinished(e -> end());
    }

    private void end() {
        if (strokeExist) gc.setStroke(Color.rgb(244, 244, 244));
        else gc.setStroke(Color.GREEN);

        Timeline timeline1;
        Timeline timeline2;

        gc.setFill(Color.GREEN);
        timeline1 = coloredTimeLine(new Move(0, 0, arrayList.get(0), 0, false, true), Color.GREEN);
        timeline2 = coloredTimeLine(new Move(1, 0, arrayList.get(1), 0, false, true), Color.GREEN);
        Timeline finalTimeline = timeline2;
        timeline1.setOnFinished(e -> finalTimeline.play());
        timeline1.play();

        for (int i = 2; i < arrayList.size(); i++) {
            timeline1 = coloredTimeLine(new Move(i, 0, arrayList.get(i), 0, false, true), Color.GREEN);
            Timeline finalTimeline1 = timeline1;
            timeline2.setOnFinished(e -> finalTimeline1.play());
            timeline2 = timeline1;
        }
    }

    private Timeline coloredTimeLine(Move current, Color color) {
        if (current.singleCol) {
            return new Timeline(
                    new KeyFrame(Duration.seconds(delay), e -> gc.setFill(color)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.clearRect(current.i * blockSize, 0, blockSize, theCanvas.getHeight())),
                    new KeyFrame(Duration.seconds(delay), e -> gc.fillRect(current.i * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.strokeRect(current.i * blockSize, 0, blockSize, current.heightI))
            );
        } else if (current.swap) {
            return new Timeline(
                    new KeyFrame(Duration.seconds(delay), e -> gc.setFill(color)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.clearRect(current.i * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.clearRect(current.j * blockSize, 0, blockSize, current.heightJ)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.fillRect(current.j * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.fillRect(current.i * blockSize, 0, blockSize, current.heightJ)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.strokeRect(current.j * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.strokeRect(current.i * blockSize, 0, blockSize, current.heightJ))
            );
        } else {
            return new Timeline(
                    new KeyFrame(Duration.seconds(delay), e -> gc.setFill(color)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.clearRect(current.i * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.clearRect(current.j * blockSize, 0, blockSize, current.heightJ)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.fillRect(current.i * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.strokeRect(current.i * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.fillRect(current.j * blockSize, 0, blockSize, current.heightJ)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.strokeRect(current.j * blockSize, 0, blockSize, current.heightJ))
            );
        }
    }
}
