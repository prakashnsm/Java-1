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

public class Example extends Application {
    private Animation animation;

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(final Stage primaryStage) {
    final Group root = new Group();
    Scene scene = new Scene(root);
    //Make stage transparent 
    //primaryStage.initStyle(StageStyle.TRANSPARENT);
    scene.setFill(Color.TRANSPARENT);
    //Rectangle rect = new Rectangle(0, 0, 300, 300);
    //rect.setFill(Color.RED);

    // Adding circles at Mouse Click 
    scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){    

        Timeline timeline = new Timeline();
        @Override
        public void handle(MouseEvent me){
             Group listOfCircles = new Group();
             for(int i=0; i < 5; i++){
                 Circle circle = new Circle(50*Math.random());
                 Color c = new Color(Math.random(),Math.random(),Math.random(),1.0);
                 circle.setFill(c);
                 listOfCircles.getChildren().add(circle);
                 }
                 root.getChildren().add(listOfCircles);
                 for (Node circle : listOfCircles.getChildren()){
                     timeline.getKeyFrames().addAll(
                             new KeyFrame(Duration.ZERO, 
                             new KeyValue(circle.translateXProperty(),800),
                             new KeyValue(circle.translateYProperty(),500)
                             ), 
                             new KeyFrame(new Duration(2000), 
                             new KeyValue(circle.translateXProperty(),me.getSceneX()+10),
                             new KeyValue(circle.translateYProperty(),me.getSceneY()+10)
                             ));                                   
              }
              timeline.play();
              primaryStage.show();   

            }

          });       


    //scene.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {        
      //                      public void handle(MouseEvent me2){
        //                    scene.getChildren().clear();
          //          }  
   // });





    //public double getSampleWidth() { return 400; }

//    public double getSampleHeight() { return 150; }


    //root.getChildren().add();
    primaryStage.setScene(new Scene(root, 300, 250));
    //primaryStage.initStyle(StageStyle.TRANSPARENT);
    primaryStage.setScene(scene);

    }
}