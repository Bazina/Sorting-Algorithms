package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Vision extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Vision.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("Icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Vision");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}