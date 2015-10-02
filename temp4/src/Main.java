/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.Random;
import javafx.event.Event;
import javafx.scene.control.Button;
 
/**
 * An example of animation generated from key events. Click the grey area to
 * give it focus and try typing letters.
 *
 * @see javafx.scene.input.KeyEvent
 * @see javafx.animation.Interpolator
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Button button = new Button("Click me!!");
        Group parent = new Group(button);
        button.setOnMouseClicked(new EventHandler() {

                public void handle(Event t) {
                Group group = (Group) button.getParent();
                group.getChildren().remove(button);
            }
        });
        Scene scene = new Scene(parent);
        
        stage.setScene(scene);        
        stage.show();
    }
}