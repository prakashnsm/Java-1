package org.example;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResizeScene extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final StackPane stack = new StackPane();
        final Text resolution = new Text();
        stack.getChildren().add(resolution);

        final Scene scene = new Scene(stack);
        primaryStage.setScene(scene);

        final InvalidationListener resizeListener = new InvalidationListener() {
            @Override
            public void invalidated(final Observable observable) {
                final double width = scene.getWidth();
                final double height = scene.getHeight();
                resolution.setText(width + " x " + height);
            }
        };
        scene.widthProperty().addListener(resizeListener);
        scene.heightProperty().addListener(resizeListener);

        // Initial Size
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}