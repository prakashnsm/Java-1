package javafx_exdraw;
 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
 
/**
*
* @author erix7
*/
public class JavaFX_exDraw extends Application {
 
 /**
  * @param args the command line arguments
  */
 public static void main(String[] args) {
     launch(args);
 }
 
 @Override
 public void start(Stage primaryStage) {
     primaryStage.setTitle("java-buddy.blogspot.com");
     Group root = new Group();
     Scene scene = new Scene(root, 400, 300, Color.WHITE);
   
     
     Rectangle rect1 = RectangleBuilder.create()
             .x(50)
             .y(50)
             .width(100)
             .height(100)
             .build();
   
     Rectangle rect2 = RectangleBuilder.create()
             .x(150)
             .y(150)
             .width(100)
             .height(100)
             .fill(Color.BLUE)
             .build();
   
     Rectangle roundRect = RectangleBuilder.create()
             .x(250)
             .y(50)
             .width(250)
             .height(250)
             .arcWidth(30)
             .arcHeight(30)
             .fill(Color.RED)
             .build();
 
     root.getChildren().add(rect1);
     root.getChildren().add(rect2);
     root.getChildren().add(roundRect);
   
     primaryStage.setScene(scene);
     primaryStage.show();
 }
}