package com.example.rippleeffect;

import com.example.rippleeffect.ui.XButton;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RippleEffectExample");
        var scene = new Scene(createContent(), 600, 400);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent createContent() {
        var xbutton = new XButton("Click me");
        xbutton.setPrefSize(125, 25);

        var root = new VBox(xbutton);
        root.setAlignment(Pos.CENTER);

        return root;
    }
}