/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mouseclicktester;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Preon
 */
public class MouseClickTester extends Application {

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) {
    final Group root = new Group();
    Scene scene = new Scene(root);
    //Rectangle rect = new Rectangle(0, 0, 300, 300);
    //rect.setFill(Color.RED);
    scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
    
        @Override
        public void handle(MouseEvent me) {
            Rectangle yellowRect = new Rectangle(me.getSceneX(), me.getSceneY(),10,50);
            yellowRect.setFill(Color.YELLOW);
            root.getChildren().add(yellowRect);
        }
    });
       
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
    
        @Override
        public void handle(MouseEvent me2) {
            //Rectangle yellowRect = new Rectangle(me.getSceneX(), me.getSceneY(),10,50);
            //yellowRect.setFill(Color.YELLOW);
            root.getChildren().clear();
        }
    });

    //root.getChildren().add();
    //primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.setScene(scene);
    primaryStage.show();
}
}