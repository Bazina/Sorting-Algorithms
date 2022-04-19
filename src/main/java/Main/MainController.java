package Main;


import Main.Controller.Move;
import Main.Implementation.Sorting.Sorting;
import Main.Implementation.Sorting.SortingStrategies.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {
    @FXML
    private Canvas theCanvas;

    @FXML
    private Button start;
    private double blockSize;

    private GraphicsContext gc;
    private List<Integer> arrayList;

    private Queue<Move> moves;
    private double delay = 0.0001;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        moves = new LinkedList<>();

        Random rd = new Random();
        theCanvas.setScaleY(-1);

        gc = theCanvas.getGraphicsContext2D();
        arrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++)
            arrayList.add((int) ((Math.abs(rd.nextInt()) + 1) % theCanvas.getHeight()));

        blockSize = theCanvas.getWidth() / arrayList.size();
        drawArray();

        start.setOnMouseClicked(e -> {
            try {
                startSorting();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void drawArray() {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.rgb(244, 244, 244));

        for (int i = 0; i < arrayList.size(); i++) {
            gc.fillRect(i * blockSize, 0, blockSize, arrayList.get(i));
            gc.strokeRect(i * blockSize, 0, blockSize, arrayList.get(i));
        }
    }

    private void startSorting() throws InterruptedException {
        Thread sort = new Thread(new Sorting(arrayList, Comparator.naturalOrder(), new StoogeSort<>(), moves));
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
                    new KeyFrame(Duration.seconds(delay), e -> gc.strokeRect(current.j * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.fillRect(current.i * blockSize, 0, blockSize, current.heightJ)),
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
