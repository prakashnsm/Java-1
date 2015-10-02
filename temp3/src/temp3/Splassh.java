package temp3;

/**
 * Put a bunch of circles on stage randomly
 */


import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
 
/**
 * A sample that demonstrates events triggered during timeline play. The circle
 * changes its radius in a linear fashion during each key frame and randomly
 * jumps to a new location along the x coordinate at the end of the key frame.
 *
 * @see javafx.animation.KeyFrame
 * @see javafx.animation.KeyValue
 * @see javafx.animation.Timeline
 * @see javafx.util.Duration
 * @see javafx.event.ActionEvent
 * @see javafx.event.EventHandler
 */
public class Splassh extends Application {
    
   //main timeline
private void init(Stage primaryStage) {
        Group root = new Group();
        //primaryStage.setResizable(false);
        Scene scene = new Scene(root);
        primaryStage.setScene(new Scene(root));
        final Group listOfCircles = new Group();
        for(int i=0; i < 30; i++){
            Circle circle = new Circle(150);
            Color c = new Color(Math.random(),Math.random(),Math.random(),1.0);
            circle.setFill(c);
            listOfCircles.getChildren().add(circle);
        }
        root.getChildren().add(listOfCircles);
        
        final Timeline timeline = new Timeline();
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
        
                @Override
                public void handle(MouseEvent m){
                    
                   for (Node circle: listOfCircles.getChildren()) {
                        timeline.getKeyFrames().addAll(
                            new KeyFrame(Duration.ZERO, // set start position at 0
                            new KeyValue(circle.translateXProperty(), m.getSceneX()),
                            new KeyValue(circle.translateYProperty(), m.getSceneY())
                            ),
                            new KeyFrame(new Duration(2000), // set end position at 40s
                            new KeyValue(circle.translateXProperty(), m.getSceneX() + 10*Math.random()),
                            new KeyValue(circle.translateYProperty(), m.getSceneY() + 10*Math.random())
                            )
                        );}                            
                   timeline.play();    
                    }
            
           
            
        });
    
    primaryStage.setScene(scene);
    primaryStage.show();
   
  }

   

    

   

    
   

}