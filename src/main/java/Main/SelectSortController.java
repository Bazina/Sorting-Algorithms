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
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class SelectSortController implements Initializable {
    @FXML
    private Canvas theCanvas;
    @FXML
    private ComboBox<String> SortComboBox;
    @FXML
    private Button start;
    private double blockSize;

    private GraphicsContext gc;
    private List<Integer> arrayList;

    private Queue<Move> moves;

    private Object sortingStrategy;
    private double delay = 0.0001;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
