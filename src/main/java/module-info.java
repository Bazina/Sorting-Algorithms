module Main {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.opencsv;
    requires java.desktop;

    opens Main.Controller to javafx.fxml;
    exports Main;
    exports Main.Controller;
}