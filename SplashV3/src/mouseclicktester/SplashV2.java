/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mouseclicktester;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Preon
 */
// On second mouse click clear the first dot and put a new one at the new spot. 
public class SplashV2 extends Application {

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) {
    final Group root = new Group();
    Scene scene = new Scene(root);
    //Make stage transparent 
    //primaryStage.initStyle(StageStyle.TRANSPARENT);
    scene.setFill(Color.TRANSPARENT);
    //Rectangle rect = new Rectangle(0, 0, 300, 300);
    //rect.setFill(Color.RED);
    
    // Adding circles at Mouse Click 
    scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
    
        @Override
        
        public void handle(MouseEvent me){
            Circle circle = new Circle(me.getSceneX(), me.getSceneY(),50*Math.random());
            Color c = new Color(Math.random(),Math.random(),Math.random(),1.0);
            circle.setFill(c);
            root.getChildren().add(circle);
        
        }
    });
    
    scene.addEventHandler(MouseEvent.MOUSE_RELEASED,new EventHandler<MouseEvent>() {
             
                @Override
                            public void handle(MouseEvent me2){
            
                            root.getChildren().clear();
                    }
            });

    
    
   

    //root.getChildren().add();
    //primaryStage.setScene(new Scene(root, 300, 250));
    //primaryStage.initStyle(StageStyle.TRANSPARENT);
    primaryStage.setScene(scene);
    primaryStage.show();
}
}