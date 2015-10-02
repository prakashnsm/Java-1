import java.awt.event.MouseEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class RemoveNodesFromCont extends Application {
    @Override
    public void start(Stage primaryStage) {
        final Group root = new Group();
        Scene scene = new Scene(root, 400, 350, Color.AQUA);
        
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
            Node n = root.lookup("#myCircle");
            if (n == null) {
                Circle circle = new Circle(event.getX(), event.getY(), 50, Color.BLUE);
                circle.setId("myCircle");
                root.getChildren().add(circle);
                System.out.println("The circle is created");
            } else {
                root.getChildren().remove(n);
                System.out.println("The circle is removed");
            }
        }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}