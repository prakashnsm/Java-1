import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;  
import static javafx.application.Application.launch;
import javafx.scene.Group;  
import javafx.scene.Node;  
import javafx.scene.Scene;  
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle;  
import javafx.stage.Stage;  
import javafx.util.Duration;

public class SplashV9 extends Application {  
    @Override  
    public void start(Stage primaryStage) {  
       final Group root = new Group();  
       
       Scene scene = new Scene(root, 400, 350);  
       scene.setOnMouseClicked(event -> {  
            
            Node n = root.lookup("#listOfCircles");
             if (n == null) {
                 double xCoord = event.getX();
                 double yCoord = event.getY();
                 Timeline timeline = new Timeline();
                 Group listOfCircles = new Group();
                 listOfCircles.setId("listOfCircles");
                 for(int i=0; i <1000*Math.random(); i++){
                 Circle circle = new Circle(xCoord, yCoord, 50*Math.random());
                 Color c = new Color(Math.random(),Math.random(),Math.random(),1.0);
                 circle.setFill(c);
                 circle.setId("myCircle"); 
                     double X1 = event.getSceneX();
                     double Y1 = event.getSceneY();
                     timeline.getKeyFrames().addAll(
                             new KeyFrame(Duration.ZERO, 
                             new KeyValue(circle.translateXProperty(),X1),
                             new KeyValue(circle.translateYProperty(),Y1)
                             ), 
                             new KeyFrame(new Duration(10000), 
                             new KeyValue(circle.translateXProperty(),X1 +200*Math.cos(6*Math.random())),
                             new KeyValue(circle.translateYProperty(),Y1 +250*Math.sin(6*Math.random()))
                             ));  
                 listOfCircles.getChildren().add(circle);
                 }
                 root.getChildren().add(listOfCircles);
                 timeline.setAutoReverse(true);
                 timeline.setCycleCount(Timeline.INDEFINITE);
                 timeline.play();
                 
                 
                 System.out.println("The circle is created");
                 System.out.println(event.getX()+ scene.getX());
                 } else {
                    root.getChildren().removeAll(n);  
                    System.out.println("The circle is removed");  
             }
       }
       );
        primaryStage.setScene(scene);  
        primaryStage.show();  
    }
    public static void main(String[] args) { 
         launch(args);  
    }
    }
    