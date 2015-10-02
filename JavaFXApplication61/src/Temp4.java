import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransitionBuilder;
import javafx.animation.SequentialTransitionBuilder;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransitionBuilder;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Temp4 extends Application {
    private Animation animation;
    Timeline timeline;

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(final Stage primaryStage) {
     final Group root = new Group();
     final Scene scene = new Scene(root);
     final Group listOfCircles = null;
    //Make stage transparent 
    //primaryStage.initStyle(StageStyle.TRANSPARENT);
    
    //Rectangle rect = new Rectangle(0, 0, 300, 300);
    //rect.setFill(Color.RED);
    
  
    // Adding circles at Mouse Click 
    scene.setOnMouseClicked(event->{ 
        
        
        Node n = root.lookup("#listOfCircles");
        //scene.setFill(Color.TRANSPARENT);
        //root.getChildren().clear();
        
        if(n == null){
            
        }
        
        @Override
        
             root.getChildren().removeAll(listOfCircles);
             Timeline timeline = new Timeline();
             Group listOfCircles = new Group();
             for(int i=0; i < 15; i++){
                 
                 Circle circle = new Circle(50*Math.random());
                 Color c = new Color(Math.random(),Math.random(),Math.random(),1.0);
                 circle.setFill(c);
                 listOfCircles.getChildren().add(circle);
                 }
                 root.getChildren().add(listOfCircles);
                 for (Node circle : listOfCircles.getChildren()){
                     
                     double X1 = me.getX();
                     double Y1 = me.getY();
                     timeline.getKeyFrames().addAll(
                             new KeyFrame(Duration.ZERO, 
                             new KeyValue(circle.translateXProperty(),X1),
                             new KeyValue(circle.translateYProperty(),Y1)
                             ), 
                             new KeyFrame(new Duration(10000), 
                             new KeyValue(circle.translateXProperty(),X1 +200*Math.cos(6*Math.random())),
                             new KeyValue(circle.translateYProperty(),Y1 +250*Math.sin(6*Math.random()))
                             ));  
                     
                     double X2 = me.getX();
                     double Y2 = me.getY();   
                     
                    /* scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {        
                            @Override
                            public void handle(MouseEvent me){              
                           
                            root.getChildren().clear();
                            
                                   }  
                              });  */
                      
                 
                    }
                 
                      
                     timeline.play();
                     timeline.setCycleCount(Timeline.INDEFINITE);
                     timeline.setAutoReverse(true);
                     
              
                       /*  */
              
              //primaryStage.show();   

            }

          });       
            
           
          
          
    

    //public double getSampleWidth() { return 400; }

    //   public double getSampleHeight() { return 150; }
                    

    //root.getChildren().add();
                      primaryStage.setScene(scene);
                      primaryStage.show();

    }
}