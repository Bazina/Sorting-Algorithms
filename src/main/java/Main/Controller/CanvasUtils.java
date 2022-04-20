package Main.Controller;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.List;
import java.util.Queue;

public class CanvasUtils {
    private final Canvas theCanvas;
    private final GraphicsContext gc;
    private double delay;
    private double blockSize;
    private boolean strokeExist;
    private List<Integer> arrayList;
    private boolean sorting;

    public CanvasUtils(Canvas theCanvas) {
        this.theCanvas = theCanvas;
        gc = theCanvas.getGraphicsContext2D();
        this.delay = 0.01 ;
    }

    public void drawArray() {
        gc.setFill(Color.BLACK);

        if (strokeExist) gc.setStroke(Color.rgb(244, 244, 244));
        else gc.setStroke(Color.BLACK);

        for (int i = 0; i < arrayList.size(); i++) {
            gc.fillRect(i * blockSize, 0, blockSize, arrayList.get(i));
            gc.strokeRect(i * blockSize, 0, blockSize, arrayList.get(i));
        }
    }

    public void startDrawSorting(Queue<Move> moves) {
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

    public void end() {
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
        sorting = false;
    }

    public Timeline coloredTimeLine(Move current, Color color) {
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
                    new KeyFrame(Duration.seconds(delay), e -> gc.clearRect(current.i * blockSize, 0, blockSize, theCanvas.getHeight())),
                    new KeyFrame(Duration.seconds(delay), e -> gc.clearRect(current.j * blockSize, 0, blockSize, theCanvas.getHeight())),
                    new KeyFrame(Duration.seconds(delay), e -> gc.fillRect(current.j * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.fillRect(current.i * blockSize, 0, blockSize, current.heightJ)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.strokeRect(current.j * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.strokeRect(current.i * blockSize, 0, blockSize, current.heightJ))
            );
        } else {
            return new Timeline(
                    new KeyFrame(Duration.seconds(delay), e -> gc.setFill(color)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.clearRect(current.i * blockSize, 0, blockSize, theCanvas.getHeight())),
                    new KeyFrame(Duration.seconds(delay), e -> gc.clearRect(current.j * blockSize, 0, blockSize, theCanvas.getHeight())),
                    new KeyFrame(Duration.seconds(delay), e -> gc.fillRect(current.i * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.strokeRect(current.i * blockSize, 0, blockSize, current.heightI)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.fillRect(current.j * blockSize, 0, blockSize, current.heightJ)),
                    new KeyFrame(Duration.seconds(delay), e -> gc.strokeRect(current.j * blockSize, 0, blockSize, current.heightJ))
            );
        }
    }

    public void setBlockSize(double blockSize) {
        this.blockSize = blockSize;
    }

    public void setStrokeExist(boolean strokeExist) {
        this.strokeExist = strokeExist;
    }

    public void setData(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public void clear() {
        gc.clearRect(0, 0, theCanvas.getWidth(), theCanvas.getHeight());
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }

    public boolean isSorting() {
        return sorting;
    }

    public void setSorting(boolean sorting) {
        this.sorting = sorting;
    }
}
