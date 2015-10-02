package mouseclicktester;

import javafx.animation.Animation;
import javafx.animation.PauseTransitionBuilder;
import javafx.animation.SequentialTransitionBuilder;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransitionBuilder;
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
import javafx.util.Duration;

public class SplashV3 extends Application {
    private Animation animation;

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
            animation = SequentialTransitionBuilder.create()
            .node(circle)
            .children(
                TranslateTransitionBuilder.create()
                    .duration(Duration.seconds(2))
                    .fromX(0)
                    .toX(100*Math.sin(6*Math.random()))
                    .fromY(0)
                    .toY(100*Math.cos(6*Math.random()))    
                    
                    .build(),
                PauseTransitionBuilder.create()
                    .duration(Duration.seconds(2))
                    .build(),
                TranslateTransitionBuilder.create()
                    .duration(Duration.seconds(2))
                    .fromX(200)
                    .toX(350)
                    .build()
            )
            .cycleCount(Timeline.INDEFINITE)
            .autoReverse(true)
            .build();   
            animation.play();
        }
        
             
     });

    
    scene.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
             
                
                            public void handle(MouseEvent me2){
                            root.getChildren().clear();
                    }  
    });
   
    
    

 
    //public double getSampleWidth() { return 400; }
 
//    public double getSampleHeight() { return 150; }
   

    //root.getChildren().add();
    //primaryStage.setScene(new Scene(root, 300, 250));
    //primaryStage.initStyle(StageStyle.TRANSPARENT);
    primaryStage.setScene(scene);
    primaryStage.show();
}
}
    