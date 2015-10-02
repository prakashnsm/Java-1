import javafx.application.Application;  
import static javafx.application.Application.launch;
import javafx.scene.Group;  
import javafx.scene.Node;  
import javafx.scene.Scene;  
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle;  
import javafx.stage.Stage;  
public class SplashV8 extends Application {  
    @Override  
    public void start(Stage primaryStage) {  
       final Group root = new Group();  
       
       Scene scene = new Scene(root, 400, 350, Color.AQUA);  
       scene.setOnMouseClicked(event -> {  
            Node n = root.lookup("#listOfCircles");
             if (n == null) {
                 Group listOfCircles = new Group();
                 listOfCircles.setId("listOfCircles");
                 for(int i=0; i <10; i++){
                 Circle circle = new Circle(event.getX()+ Math.random(), event.getY()+Math.random(), 50*Math.random(), Color.BLUE);
                 circle.setId("myCircle");  
                 listOfCircles.getChildren().add(circle);
                 }
                 root.getChildren().add(listOfCircles);
                 System.out.println("The circle is created");  
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
    